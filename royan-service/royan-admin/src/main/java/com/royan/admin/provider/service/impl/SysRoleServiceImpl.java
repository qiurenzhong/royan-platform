package com.royan.admin.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.royan.admin.api.service.dubbo.SysRoleRpcService;
import com.royan.admin.provider.mapper.SysRoleMapper;
import com.royan.admin.provider.model.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 角色信息表(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2022-05-21 10:54:35
 */
@Slf4j
@DubboService
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleRpcService {

}