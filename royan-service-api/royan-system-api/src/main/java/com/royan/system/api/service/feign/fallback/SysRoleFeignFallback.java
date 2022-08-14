package com.royan.system.api.service.feign.fallback;

import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import com.royan.system.api.pojo.bo.SysRoleBO;
import com.royan.system.api.pojo.vo.SysRoleVO;
import com.royan.system.api.service.feign.SysRoleRemoteService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 角色信息表(SysRole)服务降级
 *
 * @author makejava
 * @since 2022-05-21 11:04:35
 */
@Slf4j
@Component
public abstract class SysRoleFeignFallback implements SysRoleRemoteService {
	
	@Setter
	Throwable cause;
	
	@Override
	public ResponseData<Integer> save(SysRoleBO sysRoleBO) {
		return null;
	}
	
	@Override
	public ResponseData<Integer> update(SysRoleBO sysRoleBO) {
		return null;
	}
	
	@Override
	public ResponseData<Integer> delete(SysRoleBO sysRoleBO) {
		return null;
	}
	
	@Override
	public ResponseData<Pagination<SysRoleVO>> search(SysRoleBO sysRoleBO) {
		return null;
	}
	
}