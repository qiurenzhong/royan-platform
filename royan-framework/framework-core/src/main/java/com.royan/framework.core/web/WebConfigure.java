package com.royan.framework.core.web;

import com.royan.framework.core.web.filter.WebTraceFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO 一句话描述
 *
 * @author tianma
 * @date 2022/8/13
 * @version 1.0.0
 */
@Slf4j
@Configuration
public class WebConfigure implements WebMvcConfigurer {
	
	/***
	 * 注册自定义过滤器，拦截打印请求和响应参数以及统计耗时
	 *
	 * @param tracer
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<WebTraceFilter> filterRegistrationBean(Tracer tracer) {
		FilterRegistrationBean<WebTraceFilter> registrationBean = new FilterRegistrationBean<>();
		// 自定义Trace过滤器
		registrationBean.setFilter(new WebTraceFilter(tracer));
		registrationBean.addUrlPatterns("/*");
		// 优先级，越低越优先
		registrationBean.setOrder(-2147483642);
		return registrationBean;
	}
	
}
