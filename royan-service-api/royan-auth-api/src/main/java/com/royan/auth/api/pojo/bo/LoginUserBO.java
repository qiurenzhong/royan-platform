package com.royan.auth.api.pojo.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录请求参数
 *
 * @author tianma
 * @date 2022/8/12
 * @version 1.0.0
 */
@Data
public class LoginUserBO implements Serializable {
	
	/**
	 * 用户账号
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	
}
