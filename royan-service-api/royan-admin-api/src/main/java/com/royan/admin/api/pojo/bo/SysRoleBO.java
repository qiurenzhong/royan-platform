package com.royan.admin.api.pojo.bo;

import com.royan.admin.api.pojo.vo.SysRoleVO;
import com.royan.framework.api.model.GenericBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色信息表(SysRole)请求参数类
 *
 * @author makejava
 * @since 2022-05-21 11:04:35
 */
@Data
@EqualsAndHashCode
public class SysRoleBO extends GenericBO<SysRoleVO> {


    public SysRoleBO() {
        setVo(new SysRoleVO());
    }
}