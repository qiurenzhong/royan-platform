package com.royan.message.provider.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 邮件消息实体类
 */
@Data
public class MailMsg implements Serializable {

    /**
     * 消息ID
     */
    private String msgId;
    /**
     * 发件人
     */
    private String from;
    /**
     * 收件人
     */
    private String to;
    /**
     * 邮件标题
     */
    private String title;
    /**
     * 邮件内容
     */
    private String content;
}
