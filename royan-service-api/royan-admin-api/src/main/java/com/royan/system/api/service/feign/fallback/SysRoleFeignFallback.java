package com.royan.system.api.service.feign.fallback;

import com.royan.system.api.pojo.bo.SysRoleBO;
import com.royan.system.api.pojo.vo.SysRoleVO;
import com.royan.system.api.service.feign.SysRoleRemoteService;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色信息表(SysRole)服务降级
 *
 * @author makejava
 * @since 2022-05-21 11:04:35
 */
@Slf4j
@Component
public abstract class SysRoleFeignFallback implements SysRoleRemoteService {

    @Setter
    Throwable cause;

    @Override
    public ResponseData<SysRoleVO> get(SysRoleBO sysRoleBO) {
        return null;
    }

    @Override
    public ResponseData<List<SysRoleVO>> list(SysRoleBO sysRoleBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> save(SysRoleBO sysRoleBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> update(SysRoleBO sysRoleBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> delete(SysRoleBO sysRoleBO) {
        return null;
    }

    @Override
    public ResponseData<Pagination<SysRoleVO>> search(SysRoleBO sysRoleBO) {
        return null;
    }

}