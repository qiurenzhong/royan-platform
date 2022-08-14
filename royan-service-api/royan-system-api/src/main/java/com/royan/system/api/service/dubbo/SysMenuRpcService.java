package com.royan.system.api.service.dubbo;

import com.royan.framework.api.model.Pagination;
import com.royan.system.api.pojo.bo.SysMenuBO;
import com.royan.system.api.pojo.vo.SysMenuVO;

import java.util.List;

/**
 * 用户信息表(SysMenu)表服务接口
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
public interface SysMenuRpcService {
	
	/**
	 * 分页查询
	 *
	 * @param sysMenuBO 请求参数
	 * @return 结果
	 */
	Pagination<SysMenuVO> search(SysMenuBO sysMenuBO);
	
	/**
	 * 新增菜单
	 *
	 * @param sysMenuBO 请求参数
	 * @return 结果
	 */
	Integer save(SysMenuBO sysMenuBO);
	
	/**
	 * 修改菜单
	 *
	 * @param sysMenuBO 请求参数
	 * @return 结果
	 */
	Integer update(SysMenuBO sysMenuBO);
	
	/**
	 * 删除菜单
	 *
	 * @param sysMenuBO 请求参数
	 * @return 结果
	 */
	Integer delete(SysMenuBO sysMenuBO);
	
	/**
	 * 获取单个菜单
	 * @param sysMenuBO 请求参数
	 * @return 结果
	 */
	SysMenuVO get(SysMenuBO sysMenuBO);
	
	/**
	 * 批量获取菜单
	 * @param sysMenuBO 请求参数
	 * @return 结果
	 */
	List<SysMenuVO> batchGet(SysMenuBO sysMenuBO);
	
	/**
	 * 所有菜单树
	 *
	 * @param sysMenuBO 请求参数
	 * @return 结果
	 */
	List<SysMenuVO> selectMenuTreeAll(SysMenuBO sysMenuBO);
	
	/**
	 * 根据用户ID查询菜单权限
	 *
	 * @param userId 用户ID
	 * @return 权限列表
	 */
	List<String> selectMenuPermsByUserId(Long userId);
}