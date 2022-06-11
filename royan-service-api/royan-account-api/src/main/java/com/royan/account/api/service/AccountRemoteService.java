package com.royan.account.api.service;

import com.royan.account.api.ServerInterface;
import com.royan.account.api.pojo.bo.AccountBO;
import com.royan.account.api.pojo.vo.AccountVO;
import com.royan.account.api.service.fallback.AccountFeignFallback;
import com.royan.framework.api.entity.ResponseData;
import com.royan.framework.api.model.Pagination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * (Account)表接口层
 *
 * @author makejava
 * @since 2022-06-05 09:30:07
 */
@FeignClient(name = ServerInterface.SERVICE_NAME, fallback = AccountFeignFallback.class)
public interface AccountRemoteService {

    @PostMapping(value = "/account/decrease")
    ResponseData decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

    /**
     *  获取
     * @param accountBO
     * @return
     */
    @RequestMapping(value = "/account/get", method = RequestMethod.POST)
    ResponseData<AccountVO> get(@RequestBody AccountBO accountBO);
    /**
     *  获取列表
     * @param accountBO
     * @return
     */
    @RequestMapping(value = "/account/list", method = RequestMethod.POST)
    ResponseData<List<AccountVO>> list(@RequestBody AccountBO accountBO);
    /**
     *  新增
     * @param accountBO
     * @return
     */
    @RequestMapping(value = "/account/save", method = RequestMethod.POST)
    ResponseData<Integer> save(@RequestBody AccountBO accountBO);
    /**
     *  删除
     * @param accountBO
     * @return
     */
    @RequestMapping(value = "/account/delete", method = RequestMethod.POST)
    ResponseData<Integer> delete(@RequestBody AccountBO accountBO);
    /**
     *  修改
     * @param accountBO
     * @return
     */
    @RequestMapping(value = "/account/update", method = RequestMethod.POST)
    ResponseData<Integer> update(@RequestBody AccountBO accountBO);
    /**
     *  分页
     * @param accountBO
     * @return
     */
    @RequestMapping(value = "/account/search", method = RequestMethod.POST)
    ResponseData<Pagination<AccountVO>> search(@RequestBody AccountBO accountBO);

}