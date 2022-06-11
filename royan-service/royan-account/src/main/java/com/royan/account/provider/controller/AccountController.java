package com.royan.account.provider.controller;

import com.royan.account.api.pojo.bo.AccountBO;
import com.royan.account.api.pojo.vo.AccountVO;
import com.royan.account.api.service.AccountRemoteService;
import com.royan.account.provider.service.AccountService;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * (Account)表控制层
 *
 * @author makejava
 * @since 2022-06-05 02:05:41
 */
@Slf4j
@RestController
public class AccountController implements AccountRemoteService {

    @Autowired
    private AccountService accountService;

    @Override
    public ResponseData decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        return ResponseData.success(accountService.decrease(userId,money));
    }

    @Override
    public ResponseData<AccountVO> get(@RequestBody AccountBO accountBO) {
        ResponseData<AccountVO> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<List<AccountVO>> list(@RequestBody AccountBO accountBO) {
        ResponseData<List<AccountVO>> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> save(@RequestBody AccountBO accountBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> update(@RequestBody AccountBO accountBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Integer> delete(@RequestBody AccountBO accountBO) {
        ResponseData<Integer> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

    @Override
    public ResponseData<Pagination<AccountVO>> search(@RequestBody AccountBO accountBO) {
        ResponseData<Pagination<AccountVO>> resp = new ResponseData<>();
        resp.setData(null).ok();
        return resp;
    }

}