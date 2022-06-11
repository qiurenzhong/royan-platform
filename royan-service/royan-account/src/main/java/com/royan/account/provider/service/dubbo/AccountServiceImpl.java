package com.royan.account.provider.service.dubbo;

import com.royan.account.api.service.dubbo.AccountService;
import com.royan.account.provider.mapper.AccountMapper;
import com.royan.account.provider.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * (Account)表服务实现类
 *
 * @author tianma
 * @date 2022/6/10
 * @version 1.0.0
 */
@Slf4j
@DubboService
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Integer decrease(Long userId, BigDecimal money) {
        log.info("------->account-service 开始查询账户余额");
        Account account = accountMapper.selectByUserId(userId);
        log.info("------->account-service 账户余额查询完成，" + account);
        if (account != null && account.getResidue().intValue() >= money.intValue()) {
            log.info("------->account-service 开始从账户余额中扣钱！");
            int decrease = accountMapper.decrease(userId, money);
            log.info("------->account-service 从账户余额中扣钱完成");
            return decrease;
        } else {
            log.info("账户余额不足，开始回滚！");
            throw new RuntimeException("账户余额不足！");
        }
    }

}
