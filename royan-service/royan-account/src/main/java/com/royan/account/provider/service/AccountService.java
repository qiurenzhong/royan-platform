package com.royan.account.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.royan.account.provider.model.Account;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 用户信息表(Account)表服务接口
 *
 * @author Qiurz
 * @since 2021-04-18 23:36:58
 */
public interface AccountService extends IService<Account> {

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  金额
     */
    int decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}