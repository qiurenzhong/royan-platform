package com.royan.framework.api.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Qiurz
 * @date 2021/7/26
 */
@Data
public class ClientInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String DEVICE_APP = "app";
    public static final String DEVICE_PC = "pc";
    public static final String DEVICE_WECHAT = "wechat";
    private String computerName;
    private String networkCard;
    private String mainBoardNo;
    private String device;
    private String version;
}
