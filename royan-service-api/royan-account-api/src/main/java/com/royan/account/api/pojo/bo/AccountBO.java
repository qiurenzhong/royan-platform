package com.royan.account.api.pojo.bo;

import com.royan.account.api.pojo.vo.AccountVO;
import com.royan.framework.api.model.GenericBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * (Account)请求参数类
 *
 * @author makejava
 * @since 2022-06-05 09:30:08
 */
@Data
@EqualsAndHashCode
public class AccountBO extends GenericBO<AccountVO> {


    public AccountBO() {
        setVo(new AccountVO());
    }
}