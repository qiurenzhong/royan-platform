package com.royan.storage.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.royan.storage.provider.mapper.StorageMapper;
import com.royan.storage.provider.model.Storage;
import com.royan.storage.provider.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * (t_storage)表服务实现类
 *
 * @author makejava
 * @since 2022-06-05 10:16:39
 */
@Slf4j
@Service("storageService")
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Override
    public int decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        log.info("------->storage-service 开始查询商品是否存在");
        Storage storage = getBaseMapper().selectByProductId(productId);
        if (storage != null && storage.getResidue().intValue() >= count.intValue()) {
            Storage storage2 = new Storage();
            storage2.setProductId(productId);
            storage.setUsed(storage.getUsed() + count);
            storage.setResidue(storage.getTotal().intValue() - storage.getUsed());
            int decrease = getBaseMapper().decrease(storage);
            log.info("------->storage-service 扣减库存成功");
            return decrease;
        } else {
            log.info("------->storage-service 库存不足，开始回滚！");
            throw new RuntimeException("库存不足，扣减库存失败！");
        }
    }
}