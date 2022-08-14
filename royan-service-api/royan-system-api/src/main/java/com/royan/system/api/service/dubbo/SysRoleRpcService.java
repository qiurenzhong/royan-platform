package com.royan.system.api.service.dubbo;

import com.royan.framework.api.model.Pagination;
import com.royan.system.api.pojo.bo.SysRoleBO;
import com.royan.system.api.pojo.vo.SysRoleVO;

import java.util.List;

/**
 * 角色信息表(SysRole)表服务接口
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
public interface SysRoleRpcService {
	
	/**
	 * 分页查询
	 *
	 * @param sysRoleBO
	 * @return
	 */
	Pagination<SysRoleVO> search(SysRoleBO sysRoleBO);
	
	/**
	 * 新增角色
	 *
	 * @param sysRoleBO
	 * @return
	 */
	Integer save(SysRoleBO sysRoleBO);
	
	/**
	 * 修改角色
	 *
	 * @param sysRoleBO
	 * @return
	 */
	Integer update(SysRoleBO sysRoleBO);
	
	/**
	 * 删除角色
	 *
	 * @param sysRoleBO
	 * @return
	 */
	Integer delete(SysRoleBO sysRoleBO);
	
	/**
	 * 获取单个角色
	 * @param sysRoleBO
	 * @return
	 */
	SysRoleVO get(SysRoleBO sysRoleBO);
	
	/**
	 * 批量获取角色
	 * @param sysRoleBO
	 * @return
	 */
	List<SysRoleVO> batchGet(SysRoleBO sysRoleBO);
	
	/**
	 * 根据用户ID查询角色
	 * @param userId 登录用户ID
	 * @return 角色权限列表
	 */
	List<String> selectRolePermByUserId(Long userId);
	
}