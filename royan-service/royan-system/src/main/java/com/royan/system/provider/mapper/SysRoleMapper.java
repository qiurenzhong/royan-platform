package com.royan.system.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.royan.system.provider.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色信息表(SysRole)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-21 10:54:35
 */
@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
	
	/**
	 * 根据用户ID获取角色perm
	 * @param userId 用户ID
	 * @return 角色
	 */
	List<SysRole> selectRolePermByUserId(Long userId);


}