package com.royan.system.api.service.feign;

import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import com.royan.system.api.ServerInterface;
import com.royan.system.api.pojo.bo.SysRoleBO;
import com.royan.system.api.pojo.vo.SysRoleVO;
import com.royan.system.api.service.feign.fallback.SysRoleFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 角色信息表(SysRole)表接口层
 *
 * @author makejava
 * @since 2022-05-21 11:04:35
 */
@FeignClient(name = ServerInterface.SERVICE_NAME, fallback = SysRoleFeignFallback.class)
public interface SysRoleRemoteService {
	
	/**
	 * 新增角色信息表
	 *
	 * @param sysRoleBO
	 * @return
	 */
	@RequestMapping(value = "/sysRole/save", method = RequestMethod.POST)
	ResponseData<Integer> save(@RequestBody SysRoleBO sysRoleBO);
	
	/**
	 * 删除角色信息表
	 *
	 * @param sysRoleBO
	 * @return
	 */
	@RequestMapping(value = "/sysRole/delete", method = RequestMethod.POST)
	ResponseData<Integer> delete(@RequestBody SysRoleBO sysRoleBO);
	
	/**
	 * 修改角色信息表
	 *
	 * @param sysRoleBO
	 * @return
	 */
	@RequestMapping(value = "/sysRole/update", method = RequestMethod.POST)
	ResponseData<Integer> update(@RequestBody SysRoleBO sysRoleBO);
	
	/**
	 * 分页查询
	 *
	 * @param sysRoleBO
	 * @return
	 */
	@RequestMapping(value = "/sysRole/search", method = RequestMethod.POST)
	ResponseData<Pagination<SysRoleVO>> search(@RequestBody SysRoleBO sysRoleBO);
	
	/**
	 * 获取单个用户
	 *
	 * @param sysRoleBO
	 * @return
	 */
	@RequestMapping(value = "/sysRole/get", method = RequestMethod.POST)
	ResponseData<SysRoleVO> get(@RequestBody SysRoleBO sysRoleBO);
	
	/**
	 * 批量获取用户（最大500条）
	 *
	 * @param sysRoleBO
	 * @return
	 */
	@RequestMapping(value = "/sysRole/batchGet", method = RequestMethod.POST)
	ResponseData<List<SysRoleVO>> batchGet(@RequestBody SysRoleBO sysRoleBO);
	
}