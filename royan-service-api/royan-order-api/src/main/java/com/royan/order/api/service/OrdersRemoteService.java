package com.royan.order.api.service;

import com.royan.order.api.ServerInterface;
import com.royan.order.api.pojo.bo.OrdersBO;
import com.royan.order.api.pojo.vo.OrdersVO;
import com.royan.order.api.service.fallback.OrdersFeignFallback;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * (Orders)表接口层
 *
 * @author makejava
 * @since 2022-06-05 10:08:27
 */
@FeignClient(name = ServerInterface.SERVICE_NAME,  fallback = OrdersFeignFallback.class)
public interface OrdersRemoteService {

    /**
     *  获取
     * @param ordersBO
     * @return
     */
    @RequestMapping(value = "/orders/get", method = RequestMethod.POST)
    ResponseData<OrdersVO> get(@RequestBody OrdersBO ordersBO);
    /**
     *  获取列表
     * @param ordersBO
     * @return
     */
    @RequestMapping(value = "/orders/list", method = RequestMethod.POST)
    ResponseData<List<OrdersVO>> list(@RequestBody OrdersBO ordersBO);
    /**
     *  新增
     * @param ordersBO
     * @return
     */
    @RequestMapping(value = "/orders/save", method = RequestMethod.POST)
    ResponseData<Integer> save(@RequestBody OrdersBO ordersBO);
    /**
     *  删除
     * @param ordersBO
     * @return
     */
    @RequestMapping(value = "/orders/delete", method = RequestMethod.POST)
    ResponseData<Integer> delete(@RequestBody OrdersBO ordersBO);
    /**
     *  修改
     * @param ordersBO
     * @return
     */
    @RequestMapping(value = "/orders/update", method = RequestMethod.POST)
    ResponseData<Integer> update(@RequestBody OrdersBO ordersBO);
    /**
     *  分页
     * @param ordersBO
     * @return
     */
    @RequestMapping(value = "/orders/search", method = RequestMethod.POST)
    ResponseData<Pagination<OrdersVO>> search(@RequestBody OrdersBO ordersBO);

}