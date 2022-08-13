package com.royan.gateway.provider.filter;

import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.royan.framework.api.model.LoginUser;
import com.royan.gateway.provider.constants.AuthConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 网关全局过滤器，为请求添加用户信息
 *
 * @author tianma
 */
@Slf4j
@Component
public class ForwardAuthFilter implements GlobalFilter, Ordered {
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		ServerHttpRequest.Builder mutate = request.mutate();
		
		String url = request.getURI().getPath();
		// 跳过不需要验证的路径
		if (SaRouter.isMatch(AuthConstants.BLACK_LIST, url)) {
			return chain.filter(exchange);
		}
		LoginUser loginUser = (LoginUser) StpUtil.getSession().get(AuthConstants.USER_INFO);
		if (loginUser == null) {
			return chain.filter(exchange);
		}
		// 设置系统登录用户信息到header传递下去
		Map<String, Object> headers = new ConcurrentHashMap<>(16);
		headers.put(AuthConstants.DETAILS_USER_ID, StpUtil.getLoginId());
		headers.put(AuthConstants.DETAILS_USERNAME, loginUser.getUsername());
		headers.put(AuthConstants.AUTHORIZATION_KEY, StpUtil.getTokenValue());
		headers.put(AuthConstants.USER_INFO, JSONUtil.toJsonStr(loginUser));
		// 添加参数到请求头
		addHeaders(mutate, headers);
		return chain.filter(exchange.mutate().request(mutate.build()).build());
	}
	
	private void addHeaders(ServerHttpRequest.Builder mutate, Map<String, Object> headers) {
		for (Map.Entry<String, Object> entry : headers.entrySet()) {
			String value = Convert.toStr(entry.getValue());
			if (StrUtil.isNotBlank(value)) {
				mutate.header(entry.getKey(), valueEncode(value));
			}
		}
	}
	
	/**
	 * 内容编码
	 *
	 * @param str 内容
	 * @return 编码后的内容
	 */
	public static String valueEncode(String str) {
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return StrUtil.EMPTY;
		}
	}
	
	@Override
	public int getOrder() {
		return -200;
	}
}
