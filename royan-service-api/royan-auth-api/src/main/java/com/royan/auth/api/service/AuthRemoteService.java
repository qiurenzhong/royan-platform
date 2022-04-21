package com.royan.auth.api.service;

import com.royan.auth.api.service.fallback.AuthFeignFallback;
import com.royan.framework.api.entity.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Qiurz
 * @date 2021/7/26
 */
@FeignClient(value = "royan-auth",fallback = AuthFeignFallback.class)
public interface AuthRemoteService {

    /**
     * 根据 Access-Token 置换相关的资源: 获取账号昵称、头像、性别等信息
     * @param token
     * @return
     */
    @PostMapping(value = "/oauth/getUserInfo")
    ResponseData getUserinfo(String token);
}
