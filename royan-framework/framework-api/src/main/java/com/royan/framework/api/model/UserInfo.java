package com.royan.framework.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
	/**
	 * 用户ID
	 */
    private Long userId;
	/**
	 * 部门ID
	 */
	private Long deptId;
	/**
	 * 用户账号
	 */
	private String userName;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 用户类型（00系统用户）
	 */
	private String userType;
	/**
	 * 用户邮箱
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 用户性别（0男 1女 2未知）
	 */
	private String sex;
	/**
	 * 头像地址
	 */
	private String avatar;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 帐号状态（0正常 1停用）
	 */
	private String status;
	/**
	 * 最后登录IP
	 */
	private String loginIp;
	/**
	 * 最后登录时间
	 */
	private Date loginDate;
	/**
	 * 备注
	 */
	private String remark;



}
