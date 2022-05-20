package com.royan.message.provider.controller;

import com.royan.message.provider.entity.MailMsg;
import com.royan.message.provider.service.RabbitMsgService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private RabbitMsgService rabbitMsgService;
    @Autowired
    private ReplyingKafkaTemplate kafkaTemplate;

    @GetMapping("/message/sendMail")
    public void sendMail() {
        MailMsg mailMsg = new MailMsg();
        mailMsg.setFrom("qiurz1002@163.com");
        mailMsg.setTo("2775623589@qq.com");
        mailMsg.setTitle("测试rabbitmq发送邮件");
        mailMsg.setContent("这是一封发财的秘密邮件！！！！");
        rabbitMsgService.producerMessage(mailMsg);
    }

    @GetMapping("/send/{input}")
    @Transactional(rollbackFor = RuntimeException.class)
    public void sendFoo(@PathVariable String input) throws Exception {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("topic-k1", input);
        RequestReplyFuture<String, String, String> requestReplyFuture = kafkaTemplate.sendAndReceive(producerRecord);
        ConsumerRecord<String, String> consumerRecord = requestReplyFuture.get();
        System.out.println("return value: " + consumerRecord.value());
    }

    @SendTo
    @KafkaListener(id = "webGroup", topics = "topic-k1")
    public String listen(String input) {

        log.info("input value: {}", input);
        return "successful";
    }

    @Bean
    public ReplyingKafkaTemplate<String, String, String> replyingTemplate(ProducerFactory<String, String> pf, ConcurrentMessageListenerContainer<String, String> repliesContainer) {
        return new ReplyingKafkaTemplate(pf, repliesContainer);
    }


    @Bean
    public ConcurrentMessageListenerContainer<String, String> repliesContainer(ConcurrentKafkaListenerContainerFactory<String, String> containerFactory) {
        ConcurrentMessageListenerContainer<String, String> repliesContainer = containerFactory.createContainer("replies");
        repliesContainer.getContainerProperties().setGroupId("repliesGroup");
        repliesContainer.setAutoStartup(false);
        return repliesContainer;
    }

    @Bean
    public KafkaTemplate kafkaTemplate(ProducerFactory<String, String> pf) {
        return new KafkaTemplate(pf);
    }
}
