package com.royan.order.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.royan.account.api.service.AccountRemoteService;
import com.royan.account.api.service.dubbo.AccountService;
import com.royan.order.provider.mapper.OrdersMapper;
import com.royan.order.provider.model.Orders;
import com.royan.order.provider.service.OrdersService;
import com.royan.storage.api.service.StorageRemoteService;
import com.royan.storage.api.service.dubbo.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Orders)表服务实现类
 *
 * @author makejava
 * @since 2022-06-05 10:06:56
 */
@Slf4j
@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

//    @Autowired
//    private AccountRemoteService accountRemoteService;
//
//    @Autowired
//    private StorageRemoteService storageRemoteService;

    @DubboReference
    AccountService accountService;
    @DubboReference
    StorageService storageService;

    /**
     * 创建订单
     *
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     *
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Orders order) {
        log.info("----->开始新建订单");
        //1 新建订单
        order.setUserId(1L);
        order.setStatus(0);
        getBaseMapper().insert(order);
        //2 扣减库存
        log.info("----->订单服务开始调用库存服务，开始扣减库存");
        // openFeign方式调用
        //storageRemoteService.decrease(order.getProductId(), order.getCount());
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，扣减库存结束");
        //3 扣减账户
        log.info("----->订单服务开始调用账户服务，开始从账户扣减商品金额");
        // openFeign方式调用
        //accountRemoteService.decrease(order.getUserId(), order.getMoney());
        // dubbo方式调用
        accountService.decrease(order.getProductId(), order.getMoney());
        log.info("----->订单微服务开始调用账户，账户扣减商品金额结束");
        //4 修改订单状态，从零到1,1代表已经完成
        log.info("----->修改订单状态开始");
        getBaseMapper().update(order.getUserId(), 0);
        log.info("----->修改订单状态结束");
        log.info("----->下订单结束了------->");
        log.info("----->订单创建成功------->");
    }


}