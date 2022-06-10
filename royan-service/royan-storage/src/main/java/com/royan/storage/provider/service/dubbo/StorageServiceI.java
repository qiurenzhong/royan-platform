package com.royan.storage.provider.service.dubbo;

import com.royan.storage.api.service.dubbo.StorageService;
import com.royan.storage.provider.mapper.StorageMapper;
import com.royan.storage.provider.model.Storage;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO 一句话描述
 *
 * @author tianma
 * @date 2022/6/10
 * @version 1.0.0
 */
@Slf4j
@Service
public class StorageServiceI implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public Integer decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        log.info("------->storage-service 开始查询商品是否存在");
        Storage storage = storageMapper.selectByProductId(productId);
        if (storage != null && storage.getResidue().intValue() >= count.intValue()) {
            Storage storage2 = new Storage();
            storage2.setProductId(productId);
            storage.setUsed(storage.getUsed() + count);
            storage.setResidue(storage.getTotal().intValue() - storage.getUsed());
            int decrease = storageMapper.decrease(storage);
            log.info("------->storage-service 扣减库存成功");
            return decrease;
        } else {
            log.info("------->storage-service 库存不足，开始回滚！");
            throw new RuntimeException("库存不足，扣减库存失败！");
        }
    }
}
