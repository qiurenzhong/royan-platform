package com.royan.system.api.service.feign;

import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import com.royan.system.api.ServerInterface;
import com.royan.system.api.pojo.bo.SysUserBO;
import com.royan.system.api.pojo.vo.SysUserVO;
import com.royan.system.api.service.feign.fallback.SysUserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Qiurz
 * @date 2021/4/18
 */
@FeignClient(name = ServerInterface.SERVICE_NAME, fallback = SysUserFeignFallback.class)
public interface SysUserRemoteService {
	
	/**
	 * 分页查询用户
	 *
	 * @param userBO
	 * @return
	 */
	@RequestMapping(value = "/sysUser/search", method = RequestMethod.POST)
	ResponseData<Pagination<SysUserVO>> search(@RequestBody SysUserBO userBO);

    /**
     * 新增系统用户
     *
     * @param userBO
     * @return
     */
    @RequestMapping(value = "/sysUser/save", method = RequestMethod.POST)
    ResponseData<Integer> save(@RequestBody SysUserBO userBO);

    /**
     * 删除用户
     *
     * @param userBO
     * @return
     */
    @RequestMapping(value = "/sysUser/delete", method = RequestMethod.POST)
    ResponseData<Integer> delete(@RequestBody SysUserBO userBO);

    /**
     * 修改用户
     *
     * @param userBO
     * @return
     */
    @RequestMapping(value = "/sysUser/update", method = RequestMethod.POST)
    ResponseData<Integer> update(@RequestBody SysUserBO userBO);
	
	/**
	 * 获取单个用户
	 *
	 * @param userBO
	 * @return
	 */
	@RequestMapping(value = "/sysUser/get", method = RequestMethod.POST)
	ResponseData<SysUserVO> get(@RequestBody SysUserBO userBO);
	
	/**
	 * 批量获取用户（最大500条）
	 *
	 * @param userBO
	 * @return
	 */
	@RequestMapping(value = "/sysUser/batchGet", method = RequestMethod.POST)
	ResponseData<List<SysUserVO>> batchGet(@RequestBody SysUserBO userBO);


    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/sysUser/getUserByUsername", method = RequestMethod.POST)
    ResponseData<SysUserVO> getUserByUsername(@RequestBody String username);
    
}
