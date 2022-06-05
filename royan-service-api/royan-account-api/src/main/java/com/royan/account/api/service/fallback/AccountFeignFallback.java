package com.royan.account.api.service.fallback;

import com.royan.account.api.pojo.bo.AccountBO;
import com.royan.account.api.pojo.vo.AccountVO;
import com.royan.account.api.service.AccountRemoteService;
import com.royan.framework.api.entity.ResponseCode;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * (Account)服务降级
 *
 * @author makejava
 * @since 2022-06-05 09:30:10
 */
@Slf4j
@Component
public class AccountFeignFallback implements AccountRemoteService {

    @Setter
    Throwable cause;

    @Override
    public ResponseData decrease(Long userId, BigDecimal money) {
        return null;
    }

    @Override
    public ResponseData<AccountVO> get(AccountBO accountBO) {
        return null;
    }

    @Override
    public ResponseData<List<AccountVO>> list(AccountBO accountBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> save(AccountBO accountBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> update(AccountBO accountBO) {
        return null;
    }

    @Override
    public ResponseData<Integer> delete(AccountBO accountBO) {
        return null;
    }

    @Override
    public ResponseData<Pagination<AccountVO>> search(AccountBO accountBO) {
        return null;
    }

}