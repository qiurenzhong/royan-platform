//package com.royan.framework.auth;
//
//import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
//import cn.dev33.satoken.interceptor.SaRouteInterceptor;
//import cn.dev33.satoken.router.SaRouter;
//import cn.dev33.satoken.stp.StpUtil;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.Arrays;
//
///**
// * Sa-Token 权限认证 配置类
// */
//@Configuration
//public class SaTokenConfigure implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
//        registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
//
//        // 注册路由拦截器，自定义验证规则
//        registry.addInterceptor(new SaRouteInterceptor((req, res, handler) -> {
//
//            // 登录验证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
//            SaRouter.match("/**", "/auth/**", () -> StpUtil.checkLogin());
//
//            // 登录验证 -- 排除多个路径
//            SaRouter.match(Arrays.asList("/**"), Arrays.asList("/user/doLogin", "/user/reg"), () -> StpUtil.checkLogin());
//
//            // 角色认证 -- 拦截以 admin 开头的路由，必须具备[admin]角色或者[super-admin]角色才可以通过认证
//            SaRouter.match("/admin/**", () -> StpUtil.checkRoleOr("admin", "super-admin"));
//
//            // 权限认证 -- 不同模块, 校验不同权限
//            SaRouter.match("/user/**", () -> StpUtil.checkPermission("user"));
//            SaRouter.match("/admin/**", () -> StpUtil.checkPermission("admin"));
//            SaRouter.match("/goods/**", () -> StpUtil.checkPermission("goods"));
//            SaRouter.match("/orders/**", () -> StpUtil.checkPermission("orders"));
//            SaRouter.match("/notice/**", () -> StpUtil.checkPermission("notice"));
//            SaRouter.match("/comment/**", () -> StpUtil.checkPermission("comment"));
//
//            // 匹配 restful 风格路由
//            SaRouter.match("/article/get/{id}", () -> StpUtil.checkPermission("article"));
//
//            // 检查请求方式
//            SaRouter.match("/notice/**", () -> {
//                if (req.getMethod().equals(HttpMethod.GET.toString())) {
//                    StpUtil.checkPermission("notice");
//                }
//            });
//
//            // 提前退出 (执行SaRouter.stop()后会直接退出匹配链)
//            SaRouter.match("/test/back", () -> SaRouter.stop());
//
//            // 在多账号模式下，可以使用任意StpUtil进行校验
//            SaRouter.match("/user/**", () -> StpUtil.checkLogin());
//
//        })).addPathPatterns("/**");
//    }
//
//
//}
