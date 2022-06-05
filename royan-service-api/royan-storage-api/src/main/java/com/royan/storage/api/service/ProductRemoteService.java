package com.royan.storage.api.service;

import com.royan.storage.api.ServerInterface;
import com.royan.storage.api.pojo.bo.ProductBO;
import com.royan.storage.api.pojo.vo.ProductVO;
import com.royan.storage.api.service.fallback.ProductFeignFallback;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * (Product)表接口层
 *
 * @author makejava
 * @since 2022-06-05 10:19:21
 */
@FeignClient(name = ServerInterface.SERVICE_NAME, fallback = ProductFeignFallback.class)
public interface ProductRemoteService {

    /**
     *  获取
     * @param productBO
     * @return
     */
    @RequestMapping(value = "/product/get", method = RequestMethod.POST)
    ResponseData<ProductVO> get(@RequestBody ProductBO productBO);
    /**
     *  获取列表
     * @param productBO
     * @return
     */
    @RequestMapping(value = "/product/list", method = RequestMethod.POST)
    ResponseData<List<ProductVO>> list(@RequestBody ProductBO productBO);
    /**
     *  新增
     * @param productBO
     * @return
     */
    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    ResponseData<Integer> save(@RequestBody ProductBO productBO);
    /**
     *  删除
     * @param productBO
     * @return
     */
    @RequestMapping(value = "/product/delete", method = RequestMethod.POST)
    ResponseData<Integer> delete(@RequestBody ProductBO productBO);
    /**
     *  修改
     * @param productBO
     * @return
     */
    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    ResponseData<Integer> update(@RequestBody ProductBO productBO);
    /**
     *  分页
     * @param productBO
     * @return
     */
    @RequestMapping(value = "/product/search", method = RequestMethod.POST)
    ResponseData<Pagination<ProductVO>> search(@RequestBody ProductBO productBO);

}