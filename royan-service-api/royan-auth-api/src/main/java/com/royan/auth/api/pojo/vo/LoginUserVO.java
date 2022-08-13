package com.royan.auth.api.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录响应参数
 *
 * @author tianma
 * @date 2022/8/12
 * @version 1.0.0
 */
@Data
public class LoginUserVO implements Serializable {
	
	/**
	 *  用户账号ID
	 */
	private Long userId;
	/**
	 * 用户账号
	 */
	private String userName;
	/**
	 * 用户token信息
	 */
	private Object token;

}
