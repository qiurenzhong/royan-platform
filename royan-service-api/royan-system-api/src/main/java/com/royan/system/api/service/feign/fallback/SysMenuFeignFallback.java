package com.royan.system.api.service.feign.fallback;

import com.royan.framework.api.entity.ResponseCode;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import com.royan.system.api.pojo.bo.SysMenuBO;
import com.royan.system.api.pojo.vo.SysMenuVO;
import com.royan.system.api.service.feign.SysMenuRemoteService;
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
public abstract class SysMenuFeignFallback implements SysMenuRemoteService {

    @Setter
    Throwable cause;

    @Override
    public ResponseData<Integer> save(SysMenuBO sysMenuBO) {
	    return ResponseData.failed(ResponseCode.SYSTEM_FUNCTION_DEGRADATION);
    }

    @Override
    public ResponseData<Integer> update(SysMenuBO sysMenuBO) {
	    return ResponseData.failed(ResponseCode.SYSTEM_FUNCTION_DEGRADATION);
    }

    @Override
    public ResponseData<Integer> delete(SysMenuBO sysMenuBO) {
	    return ResponseData.failed(ResponseCode.SYSTEM_FUNCTION_DEGRADATION);
    }

    @Override
    public ResponseData<Pagination<SysMenuVO>> search(SysMenuBO sysMenuBO) {
	    return ResponseData.failed(ResponseCode.SYSTEM_FUNCTION_DEGRADATION);
    }

    @Override
    public ResponseData<List<SysMenuVO>> getMenuTree(SysMenuBO sysMenuBO) {
	    return ResponseData.failed(ResponseCode.SYSTEM_FUNCTION_DEGRADATION);
    }

}