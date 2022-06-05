package com.royan.account.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.royan.account.provider.mapper.AccountMapper;
import com.royan.account.provider.model.Account;
import com.royan.account.provider.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * (Account)表服务实现类
 *
 * @author makejava
 * @since 2022-06-05 02:05:51
 */
@Slf4j
@Service("accountService")
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Override
    public int decrease(Long userId, BigDecimal money) {
        log.info("------->account-service 开始查询账户余额");
        Account account = getBaseMapper().selectByUserId(userId);
        log.info("------->account-service 账户余额查询完成，" + account);
        if (account != null && account.getResidue().intValue() >= money.intValue()) {
            log.info("------->account-service 开始从账户余额中扣钱！");
            int decrease = getBaseMapper().decrease(userId, money);
            log.info("------->account-service 从账户余额中扣钱完成");
            return decrease;
        } else {
            log.info("账户余额不足，开始回滚！");
            throw new RuntimeException("账户余额不足！");
        }
    }
}