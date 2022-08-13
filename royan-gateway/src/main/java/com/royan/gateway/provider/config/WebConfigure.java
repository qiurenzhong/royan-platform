package com.royan.gateway.provider.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.royan.gateway.provider.constants.AuthConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关注册全局
 *
 * @author tianma
 */
@Slf4j
@Configuration
public class WebConfigure {
	
	/**
	 *  使用sa-token框架的过滤器作网关鉴权
	 * @return
	 */
	@Bean
	public SaReactorFilter getSaReactorFilter() {
		SaReactorFilter saReactorFilter = new SaReactorFilter();
		// 拦截地址
		saReactorFilter.addInclude("/**");
		// 开放地址
		saReactorFilter.addExclude("/favicon.ico");
		// 鉴权方法，每次访问进入
		saReactorFilter.setAuth(auth -> {
			log.info("请求的url:{}", SaHolder.getRequest().getUrl());
			// 登录验证 -- 拦截所有路由，并排除/auth/user/doLogin 用于开放登录
			SaRouter.match("/**").notMatch(AuthConstants.BLACK_LIST).check(r -> StpUtil.checkLogin());
			// 权限认证 -- 不同模块, 校验不同权限
			SaRouter.match("/admin/**", () -> StpUtil.checkPermission("admin"));
		});
		// 异常处理方法：每次鉴权方法出现异常进入
		saReactorFilter.setError(e -> {
			log.error(e.getMessage(), e);
			return SaResult.error(e.getMessage());
		});
		return saReactorFilter;
	}
	
	
}
