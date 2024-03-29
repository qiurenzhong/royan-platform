package com.royan.system.provider.controller;

import com.royan.system.api.pojo.bo.SysRoleBO;
import com.royan.system.api.pojo.vo.SysRoleVO;
import com.royan.system.api.service.dubbo.SysRoleRpcService;
import com.royan.system.api.service.feign.SysRoleRemoteService;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色信息表(SysRole)表控制层
 *
 * @author makejava
 * @since 2022-05-21 10:54:35
 */
@Slf4j
@RestController
public class SysRoleController implements SysRoleRemoteService {
	
	@DubboReference
	private SysRoleRpcService sysRoleService;
	
	@Override
	public ResponseData<SysRoleVO> get(SysRoleBO sysRoleBO) {
		return null;
	}
	
	@Override
	public ResponseData<List<SysRoleVO>> batchGet(SysRoleBO sysRoleBO) {
		return null;
	}
	
	@Override
	public ResponseData<Integer> save(@RequestBody SysRoleBO sysRoleBO) {
		ResponseData<Integer> resp = new ResponseData<>();
		resp.setData(null).ok();
		return resp;
	}
	
	@Override
	public ResponseData<Integer> update(@RequestBody SysRoleBO sysRoleBO) {
		ResponseData<Integer> resp = new ResponseData<>();
		resp.setData(null).ok();
		return resp;
	}
	
	@Override
	public ResponseData<Integer> delete(@RequestBody SysRoleBO sysRoleBO) {
		ResponseData<Integer> resp = new ResponseData<>();
		resp.setData(null).ok();
		return resp;
	}
	
	@Override
	public ResponseData<Pagination<SysRoleVO>> search(@RequestBody SysRoleBO sysRoleBO) {
		ResponseData<Pagination<SysRoleVO>> resp = new ResponseData<>();
		resp.setData(null).ok();
		return resp;
	}
	
}