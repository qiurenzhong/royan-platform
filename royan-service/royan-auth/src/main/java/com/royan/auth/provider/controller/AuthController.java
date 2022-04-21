package com.royan.auth.provider.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.oauth2.logic.SaOAuth2Handle;
import cn.dev33.satoken.oauth2.logic.SaOAuth2Util;
import com.royan.auth.api.service.AuthRemoteService;
import com.royan.framework.api.entity.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Qiurz
 * @date 2021/4/9
 */
@Slf4j
@Api(tags = "认证服务")
@RestController
public class AuthController implements AuthRemoteService {

    /**
     * 处理所有OAuth2相关请求
     *
     */
    @RequestMapping(value = "/oauth2/*",method = {RequestMethod.GET,RequestMethod.POST})
    public Object request() {
        log.info(">>>>>>>>>>进入请求url=[{}]", SaHolder.getRequest().getUrl());
        return SaOAuth2Handle.serverRequest();
    }

    @SaCheckLogin // 登录认证：只有登录之后才能进入该方法
    @Override
    @ApiOperation(value = "获取登录用户信息", notes = "token令牌必须填")
    @ApiParam(name = "token", value = "令牌", required = true)
    public ResponseData<Map<String, Object>> getUserinfo(@RequestParam("token") String token) {
        // 获取 Access-Token 对应的账号id
        Object loginId = SaOAuth2Util.getLoginIdByAccessToken(token);
        System.out.println("-------- 此Access-Token对应的账号id: " + loginId);

        // 校验 Access-Token 是否具有权限: userinfo
        //SaOAuth2Util.checkScope(token, "userinfo");

        // 模拟账号信息 （真实环境需要查询数据库获取信息）
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("nickname", "shengzhang_");
        map.put("avatar", "https://xxx.com/1.jpg");
        map.put("age", "18");
        map.put("sex", "男");
        map.put("address", "山东省 青岛市 城阳区");
        ResponseData<Map<String, Object>> resp = new ResponseData<>();
        resp.setData(map).ok();
        return resp;
    }
}
