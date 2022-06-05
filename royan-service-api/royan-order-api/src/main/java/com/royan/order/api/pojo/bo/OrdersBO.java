package com.royan.order.api.pojo.bo;

import com.royan.order.api.pojo.vo.OrdersVO;
import com.royan.framework.api.model.GenericBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * (Orders)请求参数类
 *
 * @author makejava
 * @since 2022-06-05 10:08:28
 */
@Data
@EqualsAndHashCode
public class OrdersBO extends GenericBO<OrdersVO> {


    public OrdersBO() {
        setVo(new OrdersVO());
    }
}