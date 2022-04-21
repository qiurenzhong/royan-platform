package com.royan.message.provider.service;

import com.rabbitmq.client.Channel;
import com.royan.message.provider.entity.MailMsg;
import org.springframework.amqp.core.Message;

/**
 * 消息生产服务
 */
public interface RabbitMsgService {

    /**
     * 生产消息
     *
     * @param mailMsg
     */
    void producerMessage(MailMsg mailMsg);

    /**
     * 消费消息
     *
     * @param message
     * @param channel
     */
    void consumerMessage(Message message, Channel channel);
}
