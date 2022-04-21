package com.royan.admin.api.service.feign;

import cn.dev33.satoken.id.SaIdUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * 服务内部调用鉴权
 */
@Component
public class FeignInterceptor implements RequestInterceptor {

    /**
     * 为 Feign 的 RCP调用 添加请求头Id-Token
     *
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(SaIdUtil.ID_TOKEN, SaIdUtil.getToken());
    }
}
