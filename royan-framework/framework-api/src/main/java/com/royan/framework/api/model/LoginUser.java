package com.royan.framework.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Qiurz
 * @date 2021/4/8 14:03
 */
@Data
public class LoginUser implements Serializable {
	
	/**
	 * 用户唯一标识
	 */
	private String token;
	/**
	 * 用户名id
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 权限列表
	 */
	private Set<String> permissions;
	/**
	 * 角色列表
	 */
	private Set<String> roles;
	/**
	 * 用户信息
	 */
	private UserInfo userInfo;
	/**
	 * 客户端信息
	 */
	private ClientInfo clientInfo;
	
	
	public UserInfo getUserInfo() {
		if (this.userInfo == null) {
			this.userInfo = new UserInfo();
		}
		return this.userInfo;
	}
	
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
		if (this.userInfo != null) {
			this.userId = this.userInfo.getUserId();
		}
	}
	
	
	public ClientInfo getClientInfo() {
		if (this.clientInfo == null) {
			this.clientInfo = new ClientInfo();
		}
		return this.clientInfo;
	}
	
	
	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}
	
}
