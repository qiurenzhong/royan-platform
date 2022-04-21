package com.royan.admin.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.royan.admin.api.ServerInterface;
import com.royan.admin.api.model.SysUser;
import com.royan.admin.api.pojo.bo.SysUserBO;
import com.royan.admin.api.pojo.vo.SysUserVO;
import com.royan.admin.api.service.fallback.SysUserFeignFallback;
import com.royan.framework.api.entity.ResponseData;
import com.royan.admin.api.service.feign.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Qiurz
 * @module royan-admin
 * @date 2021/4/18
 */
@FeignClient(name = ServerInterface.SERVICE_NAME, configuration = FeignInterceptor.class, fallback = SysUserFeignFallback.class)
public interface SysUserRemoteService {

    @RequestMapping(value = "/user/get", method = RequestMethod.POST)
    ResponseData<SysUserVO> get(@RequestBody SysUserBO userBO);

    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    ResponseData<List<SysUserVO>> list(@RequestBody SysUserBO userBO);

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    ResponseData<Integer> save(@RequestBody SysUserBO userBO);

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    ResponseData<Integer> delete(@RequestBody SysUserBO userBO);

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    ResponseData<Integer> update(@RequestBody SysUserBO userBO);

    @RequestMapping(value = "/user/search", method = RequestMethod.POST)
    ResponseData<Page<SysUser>> search(@RequestBody SysUserBO userBO);

    @RequestMapping(value = "/user/getUserByUsername", method = RequestMethod.POST)
    ResponseData<SysUserVO> getUserByUsername(@RequestBody String username);
}
