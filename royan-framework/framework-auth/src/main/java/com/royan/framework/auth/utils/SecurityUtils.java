package com.royan.framework.auth.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.royan.framework.api.model.LoginUser;
import com.royan.framework.auth.context.UserContextHolder;
import com.royan.framework.core.constant.AuthConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取系统用户权限工具类
 *
 * @author tianma
 * @date 2022/8/12
 * @version 1.0.0
 */
public class SecurityUtils {
	
	
	/**
	 * 获取用户ID
	 */
	public static Long getUserId() {
		return UserContextHolder.getLoginUser().getUserId();
	}
	
	/**
	 * 获取用户名称
	 */
	public static String getUserName() {
		return UserContextHolder.getLoginUser().getUsername();
	}
	
	/**
	 * 获取用户KEY
	 */
	public static String getUserKey() {
		return StpUtil.getLoginKey();
	}
	
	
	/**
	 * 获取用户登录信息
	 */
	public static LoginUser getLoginUser() {
		return UserContextHolder.getLoginUser();
	}
	
	
	/**
	 * 获取请求token
	 */
	public static String getTokenValue() {
		return UserContextHolder.getLoginUser().getToken();
	}
	
	
	/**
	 * 根据request获取请求token
	 */
	public static String getTokenValue(HttpServletRequest request) {
		return request.getHeader(AuthConstants.AUTHORIZATION_KEY);
	}
	
}
