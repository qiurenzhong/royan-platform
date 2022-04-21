package com.royan.framework.api.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Qiurz
 * @date 2021/7/26
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String ROYAN_PREFIX = "X-";
    public static final String ROYAN_ID = "userId";
    public static final String ROYAN_USERNAME = "username";
    public static final String ROYAN_NICKNAME = "nickname";
    public static final String ROYAN_PHONE = "phone";
    public static final String ROYAN_IP = "ipAddr";
    private String userId;
    private String userNumber;
    private String username;
    private String chineseName;
    private String nickname;
    private Long deptId;
    private String deptName;
    private String phone;
    private String ipAddr;



}
