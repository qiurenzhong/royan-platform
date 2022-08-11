package com.royan.admin.provider.controller;

import com.royan.admin.api.pojo.bo.SysUserBO;
import com.royan.admin.api.pojo.vo.SysUserVO;
import com.royan.admin.api.service.dubbo.SysUserRpcService;
import com.royan.admin.api.service.feign.SysUserRemoteService;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息表(SysUser)表控制层
 *
 * @author Qiurz
 * @module royan-admin
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
