package com.royan.storage.api.service;

import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import com.royan.storage.api.ServerInterface;
import com.royan.storage.api.pojo.bo.StorageBO;
import com.royan.storage.api.pojo.vo.StorageVO;
import com.royan.storage.api.service.fallback.StorageFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Storage)表接口层
 *
 * @author makejava
 * @since 2022-06-05 10:19:21
 */
@FeignClient(name = ServerInterface.SERVICE_NAME, fallback = StorageFeignFallback.class)
public interface StorageRemoteService {

    @PostMapping(value = "/storage/decrease")
    ResponseData decrease(@RequestParam("StorageId") Long StorageId, @RequestParam("count") Integer count);

    /**
     *  获取
     * @param StorageBO
     * @return
     */
    @RequestMapping(value = "/Storage/get", method = RequestMethod.POST)
    ResponseData<StorageVO> get(@RequestBody StorageBO StorageBO);
    /**
     *  获取列表
     * @param StorageBO
     * @return
     */
    @RequestMapping(value = "/Storage/list", method = RequestMethod.POST)
    ResponseData<List<StorageVO>> list(@RequestBody StorageBO StorageBO);
    /**
     *  新增
     * @param StorageBO
     * @return
     */
    @RequestMapping(value = "/Storage/save", method = RequestMethod.POST)
    ResponseData<Integer> save(@RequestBody StorageBO StorageBO);
    /**
     *  删除
     * @param StorageBO
     * @return
     */
    @RequestMapping(value = "/Storage/delete", method = RequestMethod.POST)
    ResponseData<Integer> delete(@RequestBody StorageBO StorageBO);
    /**
     *  修改
     * @param StorageBO
     * @return
     */
    @RequestMapping(value = "/Storage/update", method = RequestMethod.POST)
    ResponseData<Integer> update(@RequestBody StorageBO StorageBO);
    /**
     *  分页
     * @param StorageBO
     * @return
     */
    @RequestMapping(value = "/Storage/search", method = RequestMethod.POST)
    ResponseData<Pagination<StorageVO>> search(@RequestBody StorageBO StorageBO);

}