package com.royan.auth.api.service.fallback;

import com.royan.auth.api.pojo.bo.LoginUserBO;
import com.royan.auth.api.pojo.vo.LoginUserVO;
import com.royan.auth.api.service.AuthRemoteService;
import com.royan.framework.api.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Qiurz
 * @date 2021/7/17
 */
@Slf4j
@Component
public class AuthFeignFallback implements AuthRemoteService {
	
	
	@Override
	public ResponseData<LoginUserVO> getUserInfo() {
		return null;
	}
	
	@Override
	public Object oauth2() {
		return null;
	}
	
	@Override
	public ResponseData<LoginUserVO> doLogin(LoginUserBO loginUserBO) {
		return null;
	}
	
	@Override
	public ResponseData<String> logout() {
		return null;
	}
}
