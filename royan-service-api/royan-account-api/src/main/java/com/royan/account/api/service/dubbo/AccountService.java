package com.royan.account.api.service.dubbo;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 账户rpc服务
 *
 * @author tianma
 * @date 2022/6/10
 * @version 1.0.0
 */
public interface AccountService {

    Integer decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
