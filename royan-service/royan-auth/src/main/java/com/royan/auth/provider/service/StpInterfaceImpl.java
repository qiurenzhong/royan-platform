package com.royan.auth.provider.service;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.convert.Convert;
import com.royan.system.api.service.dubbo.SysMenuRpcService;
import com.royan.system.api.service.dubbo.SysRoleRpcService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 自定义权限验证接口扩展
 * @author tianma
 */
@Service
public class StpInterfaceImpl implements StpInterface {
	
	@DubboReference(check = false)
	private SysRoleRpcService sysRoleRpcService;
	@DubboReference(check = false)
	private SysMenuRpcService sysMenuRpcService;
	
	/**
	 * 返回一个账号所拥有的权限码集合
	 */
	@Override
	public List<String> getPermissionList(Object loginId, String loginType) {
		return sysMenuRpcService.selectMenuPermsByUserId(Convert.toLong(loginId));
	}
	
	/**
	 * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
	 */
	@Override
	public List<String> getRoleList(Object loginId, String loginType) {
		return sysRoleRpcService.selectRolePermByUserId(Convert.toLong(loginId));
	}
	
	
}
