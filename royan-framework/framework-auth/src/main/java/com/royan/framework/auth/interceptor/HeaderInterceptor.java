package com.royan.framework.auth.interceptor;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.royan.framework.api.model.LoginUser;
import com.royan.framework.auth.context.UserContextHolder;
import com.royan.framework.auth.utils.ServletUtils;
import com.royan.framework.core.constant.AuthConstants;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义请求头拦截器，将Header数据封装到线程变量中方便获取
 * 注意：此拦截器会同时验证当前用户有效期自动刷新有效期
 *
 * @author tianma
 * @date 2022/8/12
 * @version 1.0.0
 */
public class HeaderInterceptor implements AsyncHandlerInterceptor {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		// 设置登录用户信息
		String loginUserJson = Convert.toStr(ServletUtils.getHeader(request, AuthConstants.USER_INFO));
		if (StrUtil.isNotBlank(loginUserJson)) {
			LoginUser loginUser = JSONUtil.toBean(loginUserJson,LoginUser.class);
			loginUser.setUserId(Convert.toLong(ServletUtils.getHeader(request, AuthConstants.DETAILS_USER_ID)));
			loginUser.setUsername(Convert.toStr(ServletUtils.getHeader(request, AuthConstants.DETAILS_USERNAME)));
			loginUser.setToken(Convert.toStr(ServletUtils.getHeader(request, AuthConstants.AUTHORIZATION_KEY)));
			UserContextHolder.setLoginUser(loginUser);
		}
		return true;
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		UserContextHolder.remove();
	}
}
