package com.royan.message.provider.utils;

import com.royan.message.provider.entity.MailMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * 发送邮件工具类
 */
@Slf4j
@Component
public class MailUtil {


    @Autowired
    private JavaMailSender mailSender;


    /**
     * 发送简单内容的邮件
     *
     * @param mailMsg
     * @return
     */
    public boolean send(MailMsg mailMsg) {
        String from = mailMsg.getFrom();
        String to = mailMsg.getTo();
        String title = mailMsg.getTitle();
        String content = mailMsg.getContent();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(content);

        try {

            mailSender.send(simpleMailMessage);
            log.info("邮件发送{}成功！", to);
            return true;
        } catch (Exception e) {
            log.error("邮件发送失败，to:{},title:{}", to, title);
            return false;
        }

    }

}
