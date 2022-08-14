package com.royan.system.api.service.feign.fallback;

import com.royan.system.api.pojo.bo.SysUserBO;
import com.royan.system.api.pojo.vo.SysUserVO;
import com.royan.system.api.service.feign.SysUserRemoteService;
import com.royan.framework.api.entity.ResponseCode;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 服务降级
 *
 * @author Qiurz
 * @date 2021/7/17
 */
@Slf4j
@Component
public abstract class SysUserFeignFallback implements SysUserRemoteService {

    @Setter
    Throwable cause;

    @Override
    public ResponseData<Integer> save(SysUserBO userBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> update(SysUserBO userBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> delete(SysUserBO userBO) {
        return null;
    }

    @Override
    public ResponseData<Pagination<SysUserVO>> search(SysUserBO userBO) {
        return null;
    }

    @Override
    public ResponseData<SysUserVO> getUserByUsername(String username) {
        log.error("feign远程调用系统用户服务异常后的降级方法");
        return ResponseData.failed(ResponseCode.SYSTEM_RESOURCE_ACCESS_ERROR);
    }
}
