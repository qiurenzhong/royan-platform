package com.royan.system.provider.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.royan.framework.api.model.Pagination;
import com.royan.system.api.pojo.bo.SysRoleBO;
import com.royan.system.api.pojo.vo.SysRoleVO;
import com.royan.system.api.service.dubbo.SysRoleRpcService;
import com.royan.system.provider.mapper.SysRoleMapper;
import com.royan.system.provider.model.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 角色信息表(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2022-05-21 10:54:35
 */
@Slf4j
@DubboService
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleRpcService {
	
	@Override
	public Pagination<SysRoleVO> search(SysRoleBO sysRoleBO) {
		return null;
	}
	
	@Override
	public Integer save(SysRoleBO sysRoleBO) {
		return null;
	}
	
	@Override
	public Integer update(SysRoleBO sysRoleBO) {
		return null;
	}
	
	@Override
	public Integer delete(SysRoleBO sysRoleBO) {
		return null;
	}
	
	@Override
	public SysRoleVO get(SysRoleBO sysRoleBO) {
		return null;
	}
	
	@Override
	public List<SysRoleVO> batchGet(SysRoleBO sysRoleBO) {
		return null;
	}
	
	@Override
	public List<String> selectRolePermByUserId(Long userId) {
		List<String> rolePerms = new ArrayList<>();
		List<SysRole> sysRoles = this.getBaseMapper().selectRolePermByUserId(userId);
		if (CollectionUtil.isNotEmpty(sysRoles)) {
			for (SysRole sysRole : sysRoles) {
				String roleKey = sysRole.getRoleKey();
				if (StrUtil.isNotBlank(roleKey)) {
					Collections.addAll(rolePerms,roleKey);
				}
			}
		}
		return rolePerms;
	}
}