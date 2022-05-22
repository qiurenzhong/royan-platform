package com.royan.admin.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.royan.admin.api.pojo.bo.SysUserBO;
import com.royan.admin.api.pojo.vo.SysUserVO;
import com.royan.admin.provider.model.SysUser;
import com.royan.framework.api.model.Pagination;

/**
 * 用户信息表(SysUser)表服务接口
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
public interface SysUserService extends IService<SysUser> {


    /**
     * 获取根据用户名用户信息
     *
     * @param username
     * @return
     */
    SysUserVO getUserByUsername(String username);

    /**
     * 分页查询
     *
     * @param sysUserBO
     * @return
     */
    Pagination<SysUserVO> search(SysUserBO sysUserBO);

    /**
     * 新增用户
     *
     * @param sysUserBO
     * @return
     */
    Integer saveSysUser(SysUserBO sysUserBO);

    /**
     * 修改用户
     *
     * @param sysUserBO
     * @return
     */
    Integer updateSysUser(SysUserBO sysUserBO);

    /**
     * 删除用户
     *
     * @param sysUserBO
     * @return
     */
    Integer deleteSysUser(SysUserBO sysUserBO);
}
