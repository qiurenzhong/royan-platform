package com.royan.framework.core.web.filter;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.MDC;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * @author Qiurz
 * @date 2020/4/15
 */
@Slf4j
public class WebTraceFilter extends GenericFilterBean {
	
	
	public static final int ContentLength = 40960;
	private Tracer tracer;
	private static String serverName = "";
	private static String serverAddressIp = "";
	
	public WebTraceFilter(Tracer tracer) {
		this.tracer = tracer;
		this.initConfig();
	}
	
	private void initConfig() {
		InetAddress inetAddress = null;
		try {
			inetAddress = InetAddress.getLocalHost();
			serverName = inetAddress.getHostName();
			serverAddressIp = inetAddress.getHostAddress();
		} catch (UnknownHostException e) {
			log.debug("init config...", e);
		}
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException {
		if (servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse) {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();
			try {
				// logback-spring.xml文件的参数填充
				this.mdc(request);
				
				// 打印请求响应参数
				Boolean tracerFlag = true;
				if (!FilterUtils.shouldTracer(request, response)) {
					tracerFlag = false;
				}
				TraceServletRequestWrapper requestWrapper = new TraceServletRequestWrapper(request);
				TraceServletResponseWrapper responseWrapper = new TraceServletResponseWrapper(response);
				filterChain.doFilter(requestWrapper, responseWrapper);
				
				stopWatch.stop();
				String requestBody = this.traceRequestParam(requestWrapper, tracerFlag);
				String responseBody = this.traceResponseParam(responseWrapper, tracerFlag);
				if (StrUtil.isEmpty(requestBody)) {
					requestBody = "{}";
				}
				
				if (StrUtil.isEmpty(responseBody)) {
					responseBody = "{}";
				}
				log.info("请求参数==> " + requestBody);
				log.info("响应参数==> " + responseBody);
				log.info("接口耗时==> " + stopWatch.getLastTaskTimeMillis() + "ms");
			} catch (Exception ex) {
				log.error("tracer request/response param error!", ex);
			}
			
		} else {
			throw new ServletException("Filter just supports HTTP requests");
		}
	}
	
	private void mdc(HttpServletRequest request) {
		String traceId = this.getHeader(request, "X-B3-TraceId");
		String userId = this.getHeader(request, "X-user-id");
		MDC.put("traceId", traceId);
		MDC.put("remoteIP", this.getHeader(request, "X-Real-IP"));
		MDC.put("requestURL", this.getHeader(request, "X-Span-Name"));
		MDC.put("sessionId", this.getHeader(request, "X-session-id"));
		MDC.put("userId", userId);
		MDC.put("serverName", serverName);
		MDC.put("serverIp", serverAddressIp);
		String spanId = this.getHeader(request, "X-Span-Id");
		if (StrUtil.isEmpty(spanId)) {
			spanId = traceId;
		} else {
			MDC.put("spanPid", spanId);
			spanId = spanId + "_01";
		}
		MDC.put("spanId", spanId);
	}
	
	private String getHeader(HttpServletRequest request, String key) {
		return StrUtil.isEmpty(request.getHeader(key)) ? "" : request.getHeader(key);
	}
	
	private String traceResponseParam(TraceServletResponseWrapper responseWrapper, Boolean tracerFlag) {
		TraceServletOutputStream traceOutputStream = responseWrapper.getTraceServletOutputStream();
		if (null != traceOutputStream && StrUtil.isNotEmpty(traceOutputStream.getContent())) {
			String response = new String(traceOutputStream.getContent().getBytes(), StandardCharsets.UTF_8);
			if (tracerFlag) {
				Span currentSpan = this.tracer.currentSpan();
				Span newSpan;
				if (currentSpan == null) {
					newSpan = tracer.nextSpan();
				} else {
					newSpan = currentSpan;
				}
				newSpan.tag("response.body", response);
			}
			
			return response;
		} else {
			return null;
		}
	}
	
	private String traceRequestParam(TraceServletRequestWrapper requestWrapper, Boolean tracerFlag) {
		String body = "";
		String method = requestWrapper.getMethod();
		if (method.equalsIgnoreCase("GET")) {
			body = requestWrapper.getQueryString();
			if (StrUtil.isNotEmpty(body) && Base64.isBase64(body)) {
				body = new String(Base64.decodeBase64(body), StandardCharsets.UTF_8);
			}
		} else {
			int size = requestWrapper.getContentLength();
			if (size < ContentLength) {
				TraceServletInputStream traceInputStream = requestWrapper.getTraceServletInputStream();
				if (traceInputStream != null) {
					body = new String(traceInputStream.getContent().getBytes(), StandardCharsets.UTF_8);
				}
			}
		}
		
		if (StrUtil.isNotEmpty(body) && tracerFlag) {
			Span currentSpan = this.tracer.currentSpan();
			Span newSpan;
			if (currentSpan == null) {
				newSpan = tracer.nextSpan();
			} else {
				newSpan = currentSpan;
			}
			newSpan.tag("request.body", body);
		}
		
		return body;
	}
}
