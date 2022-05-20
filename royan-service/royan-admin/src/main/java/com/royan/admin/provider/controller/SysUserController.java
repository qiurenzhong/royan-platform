package com.royan.admin.provider.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.royan.admin.api.pojo.bo.SysUserBO;
import com.royan.admin.api.pojo.vo.SysUserVO;
import com.royan.admin.api.service.SysUserRemoteService;
import com.royan.admin.provider.model.SysUser;
import com.royan.admin.provider.service.SysUserService;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
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

    @Override
    public ResponseData<List<SysUserVO>> list(@RequestBody SysUserBO userBO) {
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
    public ResponseData<Integer> save(@RequestBody SysUserBO sysUserBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(sysUserService.saveSysUser(sysUserBO)).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> update(@RequestBody SysUserBO sysUserBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> delete(@RequestBody SysUserBO sysUserBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Pagination<SysUserVO>> search(@RequestBody SysUserBO sysUserBO) {
        ResponseData<Pagination<SysUserVO>> resp = new ResponseData<>();
        resp.setData(sysUserService.search(sysUserBO)).ok();
        return resp;
    }

    @Override
    public ResponseData<SysUserVO> getUserByUsername(@RequestBody String username) {
        ResponseData<SysUserVO> resp = new ResponseData<>();
        resp.setData(sysUserService.getUserByUsername(username)).ok();
        return resp;
    }

}
