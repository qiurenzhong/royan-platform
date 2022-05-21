package com.royan.admin.provider.controller;

import com.royan.admin.api.pojo.bo.SysRoleBO;
import com.royan.admin.api.pojo.vo.SysRoleVO;
import com.royan.admin.api.service.SysRoleRemoteService;
import com.royan.admin.provider.service.SysRoleService;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public ResponseData<SysRoleVO> get(@RequestBody SysRoleBO sysRoleBO) {
        ResponseData<SysRoleVO> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<List<SysRoleVO>> list(@RequestBody SysRoleBO sysRoleBO) {
        ResponseData<List<SysRoleVO>> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
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