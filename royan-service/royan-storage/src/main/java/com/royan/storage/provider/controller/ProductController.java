package com.royan.storage.provider.controller;

import com.royan.storage.api.pojo.bo.ProductBO;
import com.royan.storage.api.pojo.vo.ProductVO;
import com.royan.storage.api.service.ProductRemoteService;
import com.royan.storage.provider.service.ProductService;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Product)表控制层
 *
 * @author makejava
 * @since 2022-06-05 10:16:37
 */
@Slf4j
@RestController
public class ProductController implements ProductRemoteService {

    @Autowired
    private ProductService productService;

    @Override
    public ResponseData<ProductVO> get(@RequestBody ProductBO productBO) {
        ResponseData<ProductVO> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<List<ProductVO>> list(@RequestBody ProductBO productBO) {
        ResponseData<List<ProductVO>> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> save(@RequestBody ProductBO productBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> update(@RequestBody ProductBO productBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> delete(@RequestBody ProductBO productBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Pagination<ProductVO>> search(@RequestBody ProductBO productBO) {
        ResponseData<Pagination<ProductVO>> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

}