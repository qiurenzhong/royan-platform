package com.royan.auth.provider.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.oauth2.logic.SaOAuth2Handle;
import cn.dev33.satoken.oauth2.logic.SaOAuth2Util;
import cn.dev33.satoken.stp.StpUtil;
import com.royan.admin.api.service.SysUserRemoteService;
import com.royan.auth.api.pojo.LoginUser;
import com.royan.auth.api.service.AuthRemoteService;
import com.royan.framework.api.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 认证服务控制层
 *
 * @author Qiurz
 * @date 2021/4/9
 */
@Slf4j
@RestController
public class AuthController implements AuthRemoteService {

    @Autowired
    private SysUserRemoteService sysUserRemoteService;

    /**
     * 处理所有OAuth2相关请求
     */
    @RequestMapping(value = "/oauth2/*", method = {RequestMethod.GET, RequestMethod.POST})
    public Object request() {
        log.info(">>>>>>>>>>进入请求url=[{}]", SaHolder.getRequest().getUrl());
        return SaOAuth2Handle.serverRequest();
    }

    /**
     * 获取登录用户信息
     */
    @SaCheckLogin // 登录认证：只有登录之后才能进入该方法
    @Override
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

    /**
     * 登录
     */
    @PostMapping("/user/doLogin")
    public ResponseData<LoginUser> doLogin(@RequestBody LoginUser loginUser) {
//        String username = loginUser.getUsername();
//        if (StrUtil.isBlank(username)) {
//            throw new ApplicationException(ResponseCode.PARAM_ERROR);
//        }
//        ResponseData<SysUserVO> responseData = sysUserRemoteService.getUserByUsername(username);
//        SysUserVO sysUserVO = responseData.getData();
//        if (sysUserVO != null) {
//            System.out.println("登录成功！");
//        }


        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if ("admin".equals(loginUser.getUsername()) && "123456".equals(loginUser.getPassword())) {
            StpUtil.login(10001);
            loginUser.setUsername("admin");
            loginUser.setPassword("123456");
            loginUser.setObj(StpUtil.getTokenInfo());
            return ResponseData.success(loginUser);
        }
        return ResponseData.failed("登录失败！");
    }

    /**
     * 退出
     */
    @PostMapping("/user/logout")
    public ResponseData<String> logout() {
        StpUtil.logout();
        return ResponseData.success("退出登录成功！");
    }
}
