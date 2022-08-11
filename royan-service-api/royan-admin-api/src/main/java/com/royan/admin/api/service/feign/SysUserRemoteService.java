package com.royan.admin.api.service.feign;

import com.royan.admin.api.ServerInterface;
import com.royan.admin.api.pojo.bo.SysUserBO;
import com.royan.admin.api.pojo.vo.SysUserVO;
import com.royan.admin.api.service.fallback.SysUserFeignFallback;
import com.royan.admin.api.service.feign.FeignInterceptor;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
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
	
	/**
	 * 分页查询用户
	 *
	 * @param userBO
	 * @return
	 */
	@RequestMapping(value = "/user/search", method = RequestMethod.POST)
	ResponseData<Pagination<SysUserVO>> search(@RequestBody SysUserBO userBO);

    /**
     * 新增系统用户
     *
     * @param userBO
     * @return
     */
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    ResponseData<Integer> save(@RequestBody SysUserBO userBO);

    /**
     * 删除用户
     *
     * @param userBO
     * @return
     */
    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    ResponseData<Integer> delete(@RequestBody SysUserBO userBO);

    /**
     * 修改用户
     *
     * @param userBO
     * @return
     */
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    ResponseData<Integer> update(@RequestBody SysUserBO userBO);


    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/user/getUserByUsername", method = RequestMethod.POST)
    ResponseData<SysUserVO> getUserByUsername(@RequestBody String username);
    
}
