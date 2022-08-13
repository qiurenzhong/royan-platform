package com.royan.gateway.provider.constants;

import java.util.Arrays;
import java.util.List;

/**
 * 系统登录权限相关常量
 *
 * @author tianma
 * @date 2022/8/13
 * @version 1.0.0
 */
public class AuthConstants {
	
	/**
	 * 认证请求头key
	 */
	public static final String AUTHORIZATION_KEY = "token";
	/**
	 *  白名单
	 */
	public static final List<String> BLACK_LIST = Arrays.asList("/auth/user/doLogin", "/auth/user/logout");
	/**
	 * 用户信息
	 */
	public static final String USER_INFO = "login_user";
	/**
	 * 用户ID字段
	 */
	public static final String DETAILS_USER_ID = "user_id";
	/**
	 * 用户名字段
	 */
	public static final String DETAILS_USERNAME = "user_name";
}
