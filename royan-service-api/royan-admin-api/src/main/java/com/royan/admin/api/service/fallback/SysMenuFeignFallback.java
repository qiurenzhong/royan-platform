package com.royan.admin.api.service.fallback;

import com.royan.admin.api.pojo.bo.SysMenuBO;
import com.royan.admin.api.pojo.vo.SysMenuVO;
import com.royan.admin.api.service.feign.SysMenuRemoteService;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 菜单权限表(SysMenu)服务降级
 *
 * @author makejava
 * @since 2022-05-21 10:30:36
 */
@Slf4j
@Component
public class SysMenuFeignFallback implements SysMenuRemoteService {

    @Setter
    Throwable cause;

    @Override
    public ResponseData<SysMenuVO> get(SysMenuBO sysMenuBO) {
        return null;
    }

    @Override
    public ResponseData<List<SysMenuVO>> list(SysMenuBO sysMenuBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> save(SysMenuBO sysMenuBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> update(SysMenuBO sysMenuBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> delete(SysMenuBO sysMenuBO) {
        return null;
    }

    @Override
    public ResponseData<Pagination<SysMenuVO>> search(SysMenuBO sysMenuBO) {
        return null;
    }

    @Override
    public ResponseData<List<SysMenuVO>> getMenuTree(SysMenuBO sysMenuBO) {
        return null;
    }

}