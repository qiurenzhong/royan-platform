package com.royan.storage.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.royan.storage.provider.model.Storage;

/**
 * 用户信息表(Product)表服务接口
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
public interface StorageService extends IService<Storage> {

    int decrease(Long productId, Integer count);

}