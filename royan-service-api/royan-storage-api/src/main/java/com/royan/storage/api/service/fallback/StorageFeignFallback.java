package com.royan.storage.api.service.fallback;

import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import com.royan.storage.api.pojo.bo.StorageBO;
import com.royan.storage.api.pojo.vo.StorageVO;
import com.royan.storage.api.service.StorageRemoteService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Storage)服务降级
 *
 * @author makejava
 * @since 2022-06-05 10:19:23
 */
@Slf4j
@Component
public class StorageFeignFallback implements StorageRemoteService {

    @Setter
    Throwable cause;

    @Override
    public ResponseData decrease(Long StorageId, Integer count) {
        return null;
    }

    @Override
    public ResponseData<StorageVO> get(StorageBO StorageBO) {
        return null;
    }

    @Override
    public ResponseData<List<StorageVO>> list(StorageBO StorageBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> save(StorageBO StorageBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> update(StorageBO StorageBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> delete(StorageBO StorageBO) {
        return null;
    }

    @Override
    public ResponseData<Pagination<StorageVO>> search(StorageBO StorageBO) {
        return null;
    }

}