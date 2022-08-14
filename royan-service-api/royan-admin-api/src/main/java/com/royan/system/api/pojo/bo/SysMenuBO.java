package com.royan.system.api.pojo.bo;

import com.royan.system.api.pojo.vo.SysMenuVO;
import com.royan.framework.api.model.GenericBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单权限表(SysMenu)请求参数类
 *
 * @author makejava
 * @since 2022-05-21 10:30:35
 */
@Data
@EqualsAndHashCode
public class SysMenuBO extends GenericBO<SysMenuVO> {


    public SysMenuBO() {
        setVo(new SysMenuVO());
    }
}