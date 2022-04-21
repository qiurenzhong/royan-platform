package com.royan.message.provider.controller;

import com.royan.message.provider.entity.MailMsg;
import com.royan.message.provider.service.RabbitMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private RabbitMsgService rabbitMsgService;

    @GetMapping("/message/sendMail")
    public void sendMail() {
        MailMsg mailMsg = new MailMsg();
        mailMsg.setFrom("qiurz1002@163.com");
        mailMsg.setTo("2775623589@qq.com");
        mailMsg.setTitle("测试rabbitmq发送邮件");
        mailMsg.setContent("这是一封发财的秘密邮件！！！！");
        rabbitMsgService.producerMessage(mailMsg);
    }
}
