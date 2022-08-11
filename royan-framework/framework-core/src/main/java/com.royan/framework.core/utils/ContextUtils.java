package com.royan.framework.core.utils;

import com.royan.framework.core.domain.Context;

/**
 *  登录用户上下文信息
 *
 * InheritableThreadLocal详解:https://www.jianshu.com/p/94ba4a918ff5
 * InheritableThreadLocal主要用于子线程创建时，需要自动继承父线程的ThreadLocal变量，方便必要信息的进一步传递
 *
 * @author Qiurz
 * @date 2021/7/26
 */
public class ContextUtils {
	
	private ContextUtils() {}

    private static final ThreadLocal<Context> contextThreadLocal = new InheritableThreadLocal<>();


    public static Context getContext() {
      return contextThreadLocal.get();
    }


    public static void setContext(Context context) {
        contextThreadLocal.set(context);
    }


    public static void remove(){
        contextThreadLocal.remove();
    }
}
