package com.royan.system.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.royan.system.provider.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户信息表(SysUser)表数据库访问层
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

}

