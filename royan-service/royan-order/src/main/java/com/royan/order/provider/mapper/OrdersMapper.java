package com.royan.order.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.royan.order.provider.model.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Orders)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-05 10:06:55
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

   
}