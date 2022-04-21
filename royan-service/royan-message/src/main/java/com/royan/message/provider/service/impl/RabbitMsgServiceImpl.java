package com.royan.message.provider.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONUtil;
import com.rabbitmq.client.Channel;
import com.royan.message.provider.config.RabbitConfig;
import com.royan.message.provider.entity.MailMsg;
import com.royan.message.provider.service.RabbitMsgService;
import com.royan.message.provider.utils.MailUtil;
import com.royan.message.provider.utils.MessageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMsgServiceImpl implements RabbitMsgService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MailUtil mailUtil;

    @Override
    public void producerMessage(MailMsg mailMsg) {
        String msgId = UUID.randomUUID().toString();
        mailMsg.setMsgId(msgId);

        // 消息入库

        // 发送消息
        CorrelationData correlationData = new CorrelationData(msgId);
        rabbitTemplate.convertAndSend(RabbitConfig.MAIL_EXCHANGE_NAME,
                RabbitConfig.MAIL_ROUTING_KEY_NAME,
                MessageHelper.objToMsg(mailMsg),
                correlationData);

    }

    @Override
    @RabbitListener(queues = RabbitConfig.MAIL_QUEUE_NAME)
    public void consumerMessage(Message message, Channel channel) {
        try {
            MailMsg mail = MessageHelper.msgToObj(message, MailMsg.class);
            log.info("收到消息: {}", mail.toString());
            String msgId = mail.getMsgId();

            // 消费幂等性
        /*MsgLog msgLog = msgLogService.selectByMsgId(msgId);
        if (null == msgLog || msgLog.getStatus().equals(Constant.MsgLogStatus.CONSUMED_SUCCESS)) {
            log.info("重复消费, msgId: {}", msgId);
            return;
        }*/
            MessageProperties properties = message.getMessageProperties();
            long tag = properties.getDeliveryTag();
            boolean success = mailUtil.send(mail);
            if (success) {
                //msgLogService.updateStatus(msgId, Constant.MsgLogStatus.CONSUMED_SUCCESS);
                channel.basicAck(tag, false);// 消费确认
            } else {
                channel.basicNack(tag, false, true);
            }
        } catch (Exception e) {
            log.error("未知异常：{},{}", e.getMessage(), e);
        }

    }


}
