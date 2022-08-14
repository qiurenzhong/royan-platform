package com.royan.system.provider.controller;

import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import com.royan.system.api.pojo.bo.SysUserBO;
import com.royan.system.api.pojo.vo.SysUserVO;
import com.royan.system.api.service.dubbo.SysUserRpcService;
import com.royan.system.api.service.feign.SysUserRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户信息表(SysUser)表控制层
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
@Slf4j
@RestController
public class SysUserController implements SysUserRemoteService {
	
	@DubboReference
	private SysUserRpcService sysUserService;
	
	@Override
	public ResponseData<Pagination<SysUserVO>> search(@RequestBody SysUserBO sysUserBO) {
		ResponseData<Pagination<SysUserVO>> resp = new ResponseData<>();
		resp.setData(sysUserService.search(sysUserBO)).ok();
		return resp;
	}
	
	@Override
	public ResponseData<Integer> save(@RequestBody SysUserBO sysUserBO) {
		ResponseData<Integer> resp = new ResponseData<>();
		resp.setData(sysUserService.saveSysUser(sysUserBO)).ok();
		return resp;
	}
	
	@Override
	public ResponseData<Integer> update(@RequestBody SysUserBO sysUserBO) {
		ResponseData<Integer> resp = new ResponseData<>();
		resp.setData(sysUserService.updateSysUser(sysUserBO)).ok();
		return resp;
	}
	
	@Override
	public ResponseData<SysUserVO> get(@RequestBody SysUserBO sysUserBO) {
		ResponseData<SysUserVO> resp = new ResponseData<>();
		resp.setData(sysUserService.get(sysUserBO)).ok();
		return resp;
	}
	
	@Override
	public ResponseData<List<SysUserVO>> batchGet(@RequestBody SysUserBO sysUserBO) {
		ResponseData<List<SysUserVO>> resp = new ResponseData<>();
		resp.setData(sysUserService.batchGet(sysUserBO)).ok();
		return resp;
	}
	
	@Override
	public ResponseData<Integer> delete(@RequestBody SysUserBO sysUserBO) {
		ResponseData<Integer> resp = new ResponseData<>();
		resp.setData(sysUserService.deleteSysUser(sysUserBO)).ok();
		return resp;
	}
	
	@Override
	public ResponseData<SysUserVO> getUserByUsername(@RequestBody String username) {
		ResponseData<SysUserVO> resp = new ResponseData<>();
		resp.setData(sysUserService.getUserByUsername(username)).ok();
		return resp;
	}
	
}
