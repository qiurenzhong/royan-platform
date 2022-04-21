package com.royan.auth.provider.service;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.SaSessionCustomUtil;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 */
@Service
public class StpInterfaceImpl implements StpInterface {

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询权限
        List<String> list = new ArrayList<String>();
        list.add("101");
        list.add("user-add");
        list.add("user-delete");
        list.add("user-update");
        list.add("user-get");
        list.add("article-get");

        // 1. 获取这个账号所属角色id
        long roleId = StpUtil.getSessionByLoginId(loginId).get("Role_Id", () -> {
            return null;     // 从数据库查询这个账号所属的角色id
        });

        // 2. 获取这个角色id拥有的权限列表
        SaSession roleSession = SaSessionCustomUtil.getSessionById("role-" + roleId);
        List<String> permList = roleSession.get("Permission_List", () -> {
            return null;  // 从数据库查询这个角色id拥有的权限列表
        });

        // 3. 返回
        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询角色
        List<String> list = new ArrayList<String>();
        list.add("admin");
        list.add("super-admin");
        return list;
    }


}
