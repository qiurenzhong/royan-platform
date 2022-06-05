package com.royan.order.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.royan.order.provider.model.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * (Orders)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-05 10:06:55
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    /**
     * 修改订单状态，从零改为1
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}