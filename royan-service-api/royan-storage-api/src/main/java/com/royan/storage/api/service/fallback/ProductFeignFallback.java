package com.royan.storage.api.service.fallback;

import com.royan.storage.api.pojo.bo.ProductBO;
import com.royan.storage.api.pojo.vo.ProductVO;
import com.royan.storage.api.service.ProductRemoteService;
import com.royan.framework.api.entity.ResponseCode;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Product)服务降级
 *
 * @author makejava
 * @since 2022-06-05 10:19:23
 */
@Slf4j
@Component
public class ProductFeignFallback implements ProductRemoteService {

    @Setter
    Throwable cause;

    @Override
    public ResponseData<ProductVO> get(ProductBO productBO) {
        return null;
    }

    @Override
    public ResponseData<List<ProductVO>> list(ProductBO productBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> save(ProductBO productBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> update(ProductBO productBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> delete(ProductBO productBO) {
        return null;
    }

    @Override
    public ResponseData<Pagination<ProductVO>> search(ProductBO productBO) {
        return null;
    }

}