package com.royan.gateway.provider.service;

import cn.dev33.satoken.stp.StpInterface;
import com.royan.admin.api.service.dubbo.SysRoleRpcService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 网关统一鉴权
 * @author tianma
 */
@Component
public class StpInterfaceImpl implements StpInterface {
	
	
	@DubboReference
	private SysRoleRpcService sysRoleRpcService;
	

    /**
     * 登录用户拥有的权限列表
     *
     * @param loginId
     * @param loginType
     * @return
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> list = new ArrayList<>();
        list.add("admin");

        return list;
    }

    /**
     * 登录用户拥有的角色列表
     *
     * @param loginId
     * @param loginType
     * @return
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {

        return null;
    }
}
