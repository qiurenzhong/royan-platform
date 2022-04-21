package com.royan.framework.sentinel;

import cn.hutool.http.HttpStatus;
import com.alibaba.csp.sentinel.adapter.spring.webflux.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.royan.framework.api.entity.ResponseCode;
import com.royan.framework.api.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.servlet.http.HttpServletRequest;

/**
 *  sentinel 限流、熔断统一异常处理响应
 * @author Qiurz
 * @date 2021/5/15
 */
@Slf4j
public class SentinelAutoConfigure {

    public SentinelAutoConfigure(){
        log.info("-------sentinel启动初始化-------");
    }

    @Configuration
    @ConditionalOnClass(HttpServletRequest.class)
    public static class WebmvcHandler{

        @Bean
        public BlockExceptionHandler webmvcBlockExceptionHandler(){
            return ((request, response, e) -> {
                response.setStatus(HttpStatus.HTTP_CONFLICT);
                ResponseData result = ResponseData.failed(e.getMessage());
                response.getWriter().print(result);
            });
        }
    }


    @Configuration
    @ConditionalOnClass(ServerResponse.class)
    public static class WebfluxHandler {
        @Bean
        public BlockRequestHandler webfluxBlockExceptionHandler() {
            return (exchange, t) ->
                    ServerResponse.status(HttpStatus.HTTP_OK)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(ResponseCode.SYSTEM_LIMITING.toString()));
        }
    }


}
