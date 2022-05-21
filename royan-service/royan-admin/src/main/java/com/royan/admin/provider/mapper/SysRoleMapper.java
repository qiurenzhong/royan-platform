package com.royan.admin.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.royan.admin.provider.model.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色信息表(SysRole)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-21 10:54:35
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {


}