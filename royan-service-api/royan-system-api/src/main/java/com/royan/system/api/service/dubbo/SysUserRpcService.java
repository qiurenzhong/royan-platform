package com.royan.system.api.service.dubbo;

import com.royan.system.api.pojo.bo.SysUserBO;
import com.royan.system.api.pojo.vo.SysUserVO;
import com.royan.framework.api.model.Pagination;

import java.util.List;

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
	/**
	 *  根据用户ID获取用户
	 * @param loginId 登录ID
	 * @return
	 */
	SysUserVO getUserByUserId(String loginId);
	/**
	 * 获取单个用户
	 * @param sysUserBO
	 * @return
	 */
	SysUserVO get(SysUserBO sysUserBO);
	/**
	 * 批量获取用户
	 * @param sysUserBO
	 * @return
	 */
	List<SysUserVO> batchGet(SysUserBO sysUserBO);
}
