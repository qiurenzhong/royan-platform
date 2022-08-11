package com.royan.admin.api.service.dubbo;

import com.royan.admin.api.pojo.bo.SysUserBO;
import com.royan.admin.api.pojo.vo.SysUserVO;
import com.royan.framework.api.model.Pagination;

/**
 * 用户信息表(SysUser)表RPC服务接口
 *
 * @author tianma
 * @date 2022/8/11
 * @version 1.0.0
 */
public interface SysUserRpcService {
	
	/**
	 * 获取根据用户名用户信息
	 *
	 * @param username
	 * @return
	 */
	SysUserVO getUserByUsername(String username);
	
	/**
	 * 分页查询
	 *
	 * @param sysUserBO
	 * @return
	 */
	Pagination<SysUserVO> search(SysUserBO sysUserBO);
	
	/**
	 * 新增用户
	 *
	 * @param sysUserBO
	 * @return
	 */
	Integer saveSysUser(SysUserBO sysUserBO);
	
	/**
	 * 修改用户
	 *
	 * @param sysUserBO
	 * @return
	 */
	Integer updateSysUser(SysUserBO sysUserBO);
	
	/**
	 * 删除用户
	 *
	 * @param sysUserBO
	 * @return
	 */
	Integer deleteSysUser(SysUserBO sysUserBO);
	
}
