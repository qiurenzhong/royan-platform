package com.royan.admin.api.pojo.vo;

import com.royan.admin.api.model.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @author Qiurz
 * @date 2021/4/18
 */
@Data
public class SysUserVO extends SysUser {
    /**
     * 客户端
     */
    private String clientId;
    /**
     * 角色
     */
    private List<String> roles;
}
