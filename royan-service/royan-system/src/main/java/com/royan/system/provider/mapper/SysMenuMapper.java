package com.royan.system.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.royan.system.provider.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表数据库访问层
 *
 * @author tianma
 * @since 2022-05-21 10:04:01
 */
@Mapper
@Repository
public interface SysMenuMapper extends BaseMapper<SysMenu> {
	
	/**
	 * 查询菜单树
	 *
	 * @return
	 */
	List<SysMenu> selectMenuTreeAll();
	
	/**
	 *  根据用户ID获取菜单权限标识
	 * @param userId
	 * @return
	 */
	List<String> selectMenuPermsByUserId(Long userId);
}