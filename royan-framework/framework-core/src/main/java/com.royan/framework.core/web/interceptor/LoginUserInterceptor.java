package com.royan.framework.core.web.interceptor;

import com.royan.framework.core.domain.Context;
import com.royan.framework.core.utils.ContextUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取登录用户信息拦截器
 *
 * @author tianma
 * @date 2022/8/11
 * @version 1.0.0
 */
@Component
public class LoginUserInterceptor implements HandlerInterceptor {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		ContextUtils.setContext(new Context());
		
		return true;
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		ContextUtils.remove();
	}
}
