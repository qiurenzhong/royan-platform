package com.royan.admin.api.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Qiurz
 * @date 2021/4/18
 */
@Data
@EqualsAndHashCode
public class SysUserVO {
    /**
     * 客户端
     */
    private String clientId;
    /**
     * 角色
     */
    private List<String> roles;
}
