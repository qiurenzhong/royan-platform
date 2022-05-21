package com.royan.admin.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.royan.admin.provider.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-21 10:04:01
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 查询菜单树
     *
     * @return
     */
    List<SysMenu> selectMenuTreeAll();
}