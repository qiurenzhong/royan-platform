package com.royan.framework.core.constant;

import java.util.Collections;
import java.util.List;

/**
 * 权限相关通用常量
 *
 * @author tianma
 */
public class AuthConstants {


    /**
     * 认证请求头key
     */
    public static final String  AUTHORIZATION_KEY = "token";
    /**
     * Basic认证前缀
     */
    public static final String  BASIC_PREFIX = "Basic ";

    /**
     * Redis缓存权限规则key
     */
    public static final String  PERMISSION_ROLES_KEY = "auth:permission:roles";

    /**
     * 黑名单token前缀
     */
    public static final String  TOKEN_BLACKLIST_PREFIX = "auth:token:blacklist:";
	
	public static final String  GRANT_TYPE_KEY = "grant_type";
	
	public static final String  REFRESH_TOKEN = "refresh_token";
	
	public static final String  APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";
	
	public static final List<String> BLACK_LIST = Collections.singletonList("/auth/user/doLogin");

    /**
     * 密码加密方式
     */
    public static final String  BCRYPT = "{bcrypt}";

    /**
     * 用户信息
     */
    public static final String  USER_INFO = "login_user";
	/**
	 * 用户ID字段
	 */
	public static final String DETAILS_USER_ID = "user_id";
	/**
	 * 用户名字段
	 */
	public static final String DETAILS_USERNAME = "user_name";
	/**
	 * 系统管理员
	 */
	public static final String SYSTEM_ADMIN = "admin";
	/**
	 * 所有权限标识
	 */
	public static final String ALL_PERMS = "*:*:*";
	
}
