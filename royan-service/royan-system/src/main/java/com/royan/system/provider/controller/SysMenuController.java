package com.royan.system.provider.controller;

import com.royan.system.api.pojo.bo.SysMenuBO;
import com.royan.system.api.pojo.vo.SysMenuVO;
import com.royan.system.api.service.dubbo.SysMenuRpcService;
import com.royan.system.api.service.feign.SysMenuRemoteService;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表控制层
 *
 * @author makejava
 * @since 2022-05-21 10:24:33
 */
@Slf4j
@RestController
public class SysMenuController implements SysMenuRemoteService {
	
	@DubboReference
	private SysMenuRpcService sysMenuRpcService;
	
	@Override
	public ResponseData<SysMenuVO> get(@RequestBody SysMenuBO sysMenuBO) {
		ResponseData<SysMenuVO> resp = new ResponseData<>();
		resp.setData(null).ok();
		return resp;
	}
	
	@Override
	public ResponseData<List<SysMenuVO>> list(@RequestBody SysMenuBO sysMenuBO) {
		ResponseData<List<SysMenuVO>> resp = new ResponseData<>();
		resp.setData(null).ok();
		return resp;
	}
	
	@Override
	public ResponseData<Integer> save(@RequestBody SysMenuBO sysMenuBO) {
		ResponseData<Integer> resp = new ResponseData<>();
		resp.setData(null).ok();
		return resp;
	}
	
	@Override
	public ResponseData<Integer> update(@RequestBody SysMenuBO sysMenuBO) {
		ResponseData<Integer> resp = new ResponseData<>();
		resp.setData(null).ok();
		return resp;
	}
	
	@Override
	public ResponseData<Integer> delete(@RequestBody SysMenuBO sysMenuBO) {
		ResponseData<Integer> resp = new ResponseData<>();
		resp.setData(null).ok();
		return resp;
	}
	
	@Override
	public ResponseData<Pagination<SysMenuVO>> search(@RequestBody SysMenuBO sysMenuBO) {
		ResponseData<Pagination<SysMenuVO>> resp = new ResponseData<>();
		resp.setData(null).ok();
		return resp;
	}
	
	@Override
	public ResponseData<List<SysMenuVO>> getMenuTree(@RequestBody SysMenuBO sysMenuBO) {
		ResponseData<List<SysMenuVO>> resp = new ResponseData<>();
		resp.setData(sysMenuRpcService.selectMenuTreeAll(sysMenuBO)).ok();
		return resp;
	}
}