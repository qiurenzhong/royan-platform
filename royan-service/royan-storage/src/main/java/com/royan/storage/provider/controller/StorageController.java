package com.royan.storage.provider.controller;

import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import com.royan.storage.api.pojo.bo.StorageBO;
import com.royan.storage.api.pojo.vo.StorageVO;
import com.royan.storage.api.service.StorageRemoteService;
import com.royan.storage.provider.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Storage)表控制层
 *
 * @author makejava
 * @since 2022-06-05 10:16:37
 */
@Slf4j
@RestController
public class StorageController implements StorageRemoteService {

    @Autowired
    private StorageService storageService;

    @Override
    public ResponseData decrease(@RequestParam("StorageId") Long storageId, @RequestParam("count") Integer count) {
        return ResponseData.success(storageService.decrease(storageId,count));
    }

    @Override
    public ResponseData<StorageVO> get(@RequestBody StorageBO StorageBO) {
        ResponseData<StorageVO> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<List<StorageVO>> list(@RequestBody StorageBO StorageBO) {
        ResponseData<List<StorageVO>> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> save(@RequestBody StorageBO StorageBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> update(@RequestBody StorageBO StorageBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> delete(@RequestBody StorageBO StorageBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Pagination<StorageVO>> search(@RequestBody StorageBO StorageBO) {
        ResponseData<Pagination<StorageVO>> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

}