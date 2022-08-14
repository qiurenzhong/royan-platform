package com.royan.auth.provider.service;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.royan.system.api.pojo.vo.SysUserVO;
import com.royan.system.api.service.dubbo.SysUserRpcService;
import com.royan.auth.api.pojo.bo.LoginUserBO;
import com.royan.auth.api.pojo.vo.LoginUserVO;
import com.royan.auth.provider.utils.BcryptUtils;
import com.royan.framework.api.entity.ResponseCode;
import com.royan.framework.api.model.LoginUser;
import com.royan.framework.api.model.UserInfo;
import com.royan.framework.core.constant.AuthConstants;
import com.royan.framework.core.exception.ApplicationException;
import com.royan.framework.core.utils.BeanCopierUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * 系统登录服务层
 *
 * @author tianma
 * @date 2022/8/12
 * @version 1.0.0
 */
@Service
public class SysLoginUserService {
	
	@DubboReference(check = false)
	private SysUserRpcService sysUserRpcService;
	
	public LoginUserVO login(LoginUserBO loginUserBO) {
		String userName = loginUserBO.getUsername();
		String password = loginUserBO.getPassword();
		SysUserVO sysUserVO = sysUserRpcService.getUserByUsername(userName);
		if (sysUserVO != null) {
			String md5Pass = sysUserVO.getPassword();
			if (!BcryptUtils.matchesPassword(password, md5Pass)) {
				throw new ApplicationException(ResponseCode.USERNAME_OR_PASSWORD_ERROR);
			}
			// 登录
			StpUtil.login(sysUserVO.getId());
			// 保存用户信息
			LoginUser loginUser = new LoginUser();
			loginUser.setUserId(sysUserVO.getId());
			loginUser.setUsername(sysUserVO.getUserName());
			loginUser.setToken(StpUtil.getTokenValue());
			loginUser.setUserInfo(BeanCopierUtils.copy(sysUserVO, UserInfo.class));
			StpUtil.getSession().set(AuthConstants.USER_INFO,loginUser);
			LoginUserVO loginUserVO = new LoginUserVO();
			loginUserVO.setUserId(sysUserVO.getId());
			loginUserVO.setUserName(sysUserVO.getUserName());
			loginUserVO.setToken(StpUtil.getTokenInfo());
			return loginUserVO;
		}
		return new LoginUserVO();
	}
	
	public LoginUserVO getLoginUserInfo() {
		SaSession session = StpUtil.getSession();
		LoginUser loginUser = (LoginUser) session.get(AuthConstants.USER_INFO);
		LoginUserVO loginUserVO = new LoginUserVO();
		loginUserVO.setUserId(loginUser.getUserId());
		loginUserVO.setUserName(loginUser.getUsername());
		loginUserVO.setToken(StpUtil.getTokenValue());
		return loginUserVO;
	}
}
