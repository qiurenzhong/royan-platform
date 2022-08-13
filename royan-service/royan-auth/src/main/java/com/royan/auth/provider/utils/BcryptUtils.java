package com.royan.auth.provider.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Bcrypt工具类
 *
 * @author tianma
 * @date 2022/8/12
 * @version 1.0.0
 */
public class BcryptUtils {
	
	/**
	 *  匹配密码
	 * @param realPass 明文密码
	 * @param encodedPass 加密后字符串
	 * @return
	 */
	public static boolean matchesPassword(String realPass, String encodedPass) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(realPass, encodedPass);
	}
	
	/**
	 * 生成BCryptPasswordEncoder密码
	 * @param password 明文密码
	 * @return 加密后字符串
	 */
	public static String encrytPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}
	
}
