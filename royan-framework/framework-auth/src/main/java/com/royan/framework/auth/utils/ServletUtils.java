package com.royan.framework.auth.utils;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 客户端工具类
 *
 * @author tianma
 * @date 2022/8/12
 * @version 1.0.0
 */
public class ServletUtils {
	
	public static HttpServletRequest getRequest() {
		try {
			return getRequestAttributes().getRequest();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static HttpServletResponse getResponse() {
		try {
			return getRequestAttributes().getResponse();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getHeader(HttpServletRequest request, String key) {
		String value = request.getHeader(key);
		if (StrUtil.isBlank(value)) {
			return StrUtil.EMPTY;
		}
		return decodeValue(value);
	}
	
	public static String decodeValue(String value) {
		try {
			return URLDecoder.decode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return StrUtil.EMPTY;
		}
	}
	
	
	public static ServletRequestAttributes getRequestAttributes() {
		try {
			return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		} catch (Exception e) {
			return null;
		}
	}
}
