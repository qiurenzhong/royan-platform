package com.royan.auth.provider.controller;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.oauth2.logic.SaOAuth2Handle;
import cn.dev33.satoken.stp.StpUtil;
import com.royan.admin.api.pojo.vo.SysUserVO;
import com.royan.admin.api.service.dubbo.SysUserRpcService;
import com.royan.auth.api.pojo.LoginUser;
import com.royan.auth.api.service.AuthRemoteService;
import com.royan.framework.api.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
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
	
	@DubboReference(check = false)
	private SysUserRpcService sysUserRpcService;
	
	@Override
	public Object oauth2() {
		log.info(">>>>>>>>>>进入请求url=[{}]", SaHolder.getRequest().getUrl());
		return SaOAuth2Handle.serverRequest();
	}
	
	@Override
	public ResponseData<LoginUser> doLogin(@RequestBody LoginUser loginUser) {
		String username = loginUser.getUsername();
		SysUserVO sysUserVO = sysUserRpcService.getUserByUsername(username);
		if (sysUserVO != null) {
			StpUtil.login(sysUserVO.getId());
			loginUser.setUsername(sysUserVO.getUserName());
			loginUser.setPassword(sysUserVO.getPassword());
			loginUser.setObj(StpUtil.getTokenInfo());
			return ResponseData.success(loginUser);
		}
		return ResponseData.failed("登录失败！");
	}
	
	@Override
	public ResponseData<String> logout() {
		StpUtil.logout();
		return ResponseData.success("退出登录成功！");
	}
}
