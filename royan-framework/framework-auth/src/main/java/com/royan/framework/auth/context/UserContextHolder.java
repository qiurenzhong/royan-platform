package com.royan.framework.auth.context;

import com.royan.framework.api.model.LoginUser;

/**
 *  获取当前线程变量中的登录用户信息
 *
 * InheritableThreadLocal详解:https://www.jianshu.com/p/94ba4a918ff5
 * InheritableThreadLocal主要用于子线程创建时，需要自动继承父线程的ThreadLocal变量，方便必要信息的进一步传递
 *
 * @author tianma
 * @date 2022/8/12
 * @version 1.0.0
 */
public class UserContextHolder {
	
	
	private static final ThreadLocal<LoginUser> contextThreadLocal = new InheritableThreadLocal<>();
	
	
	public static LoginUser getLoginUser() {
		return contextThreadLocal.get();
	}
	
	
	public static void setLoginUser(LoginUser loginUser) {
		contextThreadLocal.set(loginUser);
	}
	
	
	public static void remove() {
		contextThreadLocal.remove();
	}
	
}
