package com.royan.auth.provider.controller;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.oauth2.logic.SaOAuth2Handle;
import cn.dev33.satoken.stp.StpUtil;
import com.royan.auth.api.pojo.bo.LoginUserBO;
import com.royan.auth.api.pojo.vo.LoginUserVO;
import com.royan.auth.api.service.AuthRemoteService;
import com.royan.auth.provider.service.SysLoginUserService;
import com.royan.framework.api.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证服务控制层
 *
 * @author Qiurz
 * @date 2021/4/9
 */
@Slf4j
@RestController
public class AuthController implements AuthRemoteService {
	
	@Autowired
	private SysLoginUserService sysLoginUserService;
	
	@Override
	public Object oauth2() {
		log.info(">>>>>>>>>>进入请求url=[{}]", SaHolder.getRequest().getUrl());
		return SaOAuth2Handle.serverRequest();
	}
	
	@Override
	public ResponseData<LoginUserVO> doLogin(@RequestBody LoginUserBO loginUserBO) {
		return ResponseData.success(sysLoginUserService.login(loginUserBO));
	}
	
	@Override
	public ResponseData<String> logout() {
		StpUtil.logout();
		return ResponseData.success("退出登录成功！");
	}
	
	@Override
	public ResponseData<LoginUserVO> getUserInfo() {
		return ResponseData.success(sysLoginUserService.getLoginUserInfo());
	}
}
