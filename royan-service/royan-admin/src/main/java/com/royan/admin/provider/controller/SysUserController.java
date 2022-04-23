package com.royan.admin.provider.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.royan.admin.api.model.SysUser;
import com.royan.admin.api.pojo.bo.SysUserBO;
import com.royan.admin.api.pojo.vo.SysUserVO;
import com.royan.admin.api.service.SysUserRemoteService;
import com.royan.admin.provider.service.SysUserService;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import com.royan.framework.redis.annotation.CacheLock;
import com.royan.framework.redis.annotation.CacheParams;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private SysUserService sysUserService;

    @Override
    public ResponseData<SysUserVO> get(@RequestBody SysUserBO sysUserBO) {
        ResponseData<SysUserVO> resp = new ResponseData<>();
        SysUserVO sysUserVO = new SysUserVO();
        SysUser sysUser = sysUserService.getById(sysUserBO.getId());
        BeanUtil.copyProperties(sysUser,sysUserVO);
        resp.setData(sysUserVO).ok();
        return resp;
    }

    /**
     *  CacheLock分布式锁
     * @param userBO
     * @return
     */
    @CacheLock(prefix = "test")
    @Override
    @ApiOperation(value = "查询系统用户列表", notes = "用户列表")
    public ResponseData<List<SysUserVO>> list(@CacheParams(name = "userBO") @RequestBody SysUserBO userBO) {
        ResponseData<List<SysUserVO>> resp = new ResponseData<>();
        List<SysUser> sysUsers = sysUserService.list();
        List<SysUserVO> list = Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(sysUsers)) {
            for (SysUser user : sysUsers) {
                SysUserVO sysUserVO = new SysUserVO();
                BeanUtil.copyProperties(user, sysUserVO);
                list.add(sysUserVO);
            }
        }
        resp.setData(list).ok();
        return resp;
    }

    @Override
    @ApiOperation(value = "新增系统用户", notes = "保存信息")
    @SaCheckPermission("user:add")
    public ResponseData<Integer> save(@RequestBody SysUserBO sysUserBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    @ApiOperation(value = "修改系统用户", notes = "编辑信息")
    public ResponseData<Integer> update(@RequestBody SysUserBO sysUserBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    @ApiOperation(value = "删除系统用户", notes = "删除信息")
    public ResponseData<Integer> delete(@RequestBody SysUserBO sysUserBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    @ApiOperation(value = "分页查询用户列表", notes = "分页查询")
    public ResponseData<Pagination<SysUser>> search(@RequestBody SysUserBO sysUserBO) {
        ResponseData<Pagination<SysUser>> resp = new ResponseData<>();
        resp.setData(sysUserService.search(sysUserBO)).ok();
        return resp;
    }

    @Override
    @ApiOperation(value = "根据用户名获取用户信息")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "path", dataType = "String")
    public ResponseData<SysUserVO> getUserByUsername(@RequestBody String username) {
        ResponseData<SysUserVO> resp = new ResponseData<>();
        resp.setData(sysUserService.getUserByUsername(username)).ok();
        return resp;
    }

}
