package com.royan.admin.api.service;

import com.royan.admin.api.ServerInterface;
import com.royan.admin.api.pojo.bo.SysMenuBO;
import com.royan.admin.api.pojo.vo.SysMenuVO;
import com.royan.admin.api.service.fallback.SysMenuFeignFallback;
import com.royan.admin.api.service.feign.FeignInterceptor;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表接口层
 *
 * @author makejava
 * @since 2022-05-21 10:30:34
 */
@FeignClient(name = ServerInterface.SERVICE_NAME, configuration = FeignInterceptor.class, fallback = SysMenuFeignFallback.class)
public interface SysMenuRemoteService {

    /**
     * 获取菜单权限表
     *
     * @param sysMenuBO
     * @return
     */
    @RequestMapping(value = "/sysMenu/get", method = RequestMethod.POST)
    ResponseData<SysMenuVO> get(@RequestBody SysMenuBO sysMenuBO);

    /**
     * 获取菜单权限表列表
     *
     * @param sysMenuBO
     * @return
     */
    @RequestMapping(value = "/sysMenu/list", method = RequestMethod.POST)
    ResponseData<List<SysMenuVO>> list(@RequestBody SysMenuBO sysMenuBO);

    /**
     * 新增菜单权限表
     *
     * @param sysMenuBO
     * @return
     */
    @RequestMapping(value = "/sysMenu/save", method = RequestMethod.POST)
    ResponseData<Integer> save(@RequestBody SysMenuBO sysMenuBO);

    /**
     * 删除菜单权限表
     *
     * @param sysMenuBO
     * @return
     */
    @RequestMapping(value = "/sysMenu/delete", method = RequestMethod.POST)
    ResponseData<Integer> delete(@RequestBody SysMenuBO sysMenuBO);

    /**
     * 修改菜单权限表
     *
     * @param sysMenuBO
     * @return
     */
    @RequestMapping(value = "/sysMenu/update", method = RequestMethod.POST)
    ResponseData<Integer> update(@RequestBody SysMenuBO sysMenuBO);

    /**
     * 分页菜单权限表
     *
     * @param sysMenuBO
     * @return
     */
    @RequestMapping(value = "/sysMenu/search", method = RequestMethod.POST)
    ResponseData<Pagination<SysMenuVO>> search(@RequestBody SysMenuBO sysMenuBO);

    /**
     * 获取菜单树
     *
     * @param sysMenuBO
     * @return
     */
    @RequestMapping(value = "/sysMenu/getMenuTree", method = RequestMethod.POST)
    ResponseData<List<SysMenuVO>> getMenuTree(@RequestBody SysMenuBO sysMenuBO);

}