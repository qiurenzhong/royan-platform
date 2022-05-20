package com.royan.gateway.provider.service;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 网关统一鉴权
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    /**
     * 登录用户拥有的权限列表
     *
     * @param loginId
     * @param loginType
     * @return
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        return null;
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
