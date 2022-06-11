package com.royan.storage.api.service.dubbo;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO 一句话描述
 *
 * @author tianma
 * @date 2022/6/10
 * @version 1.0.0
 */
public interface StorageService {

    Integer decrease(@RequestParam("StorageId") Long StorageId, @RequestParam("count") Integer count);
}
