package com.royan.auth.api.service;

import com.royan.auth.api.pojo.LoginUser;
import com.royan.auth.api.service.fallback.AuthFeignFallback;
import com.royan.framework.api.entity.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Qiurz
 * @date 2021/7/26
 */
@FeignClient(value = "royan-auth", fallback = AuthFeignFallback.class)
public interface AuthRemoteService {
	
	/**
	 * 处理所有OAuth2相关请求
	 */
	@GetMapping(value = "/oauth2/*")
	Object oauth2();
	
	/**
	 * 登录
	 */
	@PostMapping("/user/doLogin")
	ResponseData<LoginUser> doLogin(@RequestBody LoginUser loginUser);
	
	/**
	 * 退出
	 */
	@PostMapping("/user/logout")
	ResponseData<String> logout();

}
