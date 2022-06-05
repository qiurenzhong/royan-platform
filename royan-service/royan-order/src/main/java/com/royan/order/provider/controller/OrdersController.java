package com.royan.order.provider.controller;


import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import com.royan.order.api.pojo.bo.OrdersBO;
import com.royan.order.api.pojo.vo.OrdersVO;
import com.royan.order.api.service.OrdersRemoteService;
import com.royan.order.provider.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Orders)表控制层
 *
 * @author makejava
 * @since 2022-06-05 10:06:54
 */
@Slf4j
@RestController
public class OrdersController implements OrdersRemoteService {

    @Autowired
    private OrdersService ordersService;

    @Override
    public ResponseData<OrdersVO> get(@RequestBody OrdersBO ordersBO) {
        ResponseData<OrdersVO> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<List<OrdersVO>> list(@RequestBody OrdersBO ordersBO) {
        ResponseData<List<OrdersVO>> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> save(@RequestBody OrdersBO ordersBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> update(@RequestBody OrdersBO ordersBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> delete(@RequestBody OrdersBO ordersBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Pagination<OrdersVO>> search(@RequestBody OrdersBO ordersBO) {
        ResponseData<Pagination<OrdersVO>> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

}