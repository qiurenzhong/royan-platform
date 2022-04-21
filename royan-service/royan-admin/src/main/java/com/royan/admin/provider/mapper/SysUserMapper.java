package com.royan.admin.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.royan.admin.api.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表(SysUser)表数据库访问层
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     *  查询用户
     * @param username
     * @return
     */
    SysUser getUserByUsername(String username);
}

