package com.royan.order.api.service.fallback;

import com.royan.order.api.pojo.bo.OrdersBO;
import com.royan.order.api.pojo.vo.OrdersVO;
import com.royan.order.api.service.OrdersRemoteService;
import com.royan.framework.api.entity.ResponseCode;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Orders)服务降级
 *
 * @author makejava
 * @since 2022-06-05 10:08:29
 */
@Slf4j
@Component
public class OrdersFeignFallback implements OrdersRemoteService {

    @Setter
    Throwable cause;

    @Override
    public ResponseData<OrdersVO> get(OrdersBO ordersBO) {
        return null;
    }

    @Override
    public ResponseData<List<OrdersVO>> list(OrdersBO ordersBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> save(OrdersBO ordersBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> update(OrdersBO ordersBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> delete(OrdersBO ordersBO) {
        return null;
    }

    @Override
    public ResponseData<Pagination<OrdersVO>> search(OrdersBO ordersBO) {
        return null;
    }

}