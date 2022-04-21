package com.royan.framework.core.web.filter;

import cn.hutool.core.util.StrUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Qiurz
 */
public class FilterUtils {
    static final String METHOD_GET = "GET";
    static final String CONTENT_TYPE = "Content-Type";
    static final String REQUEST_ACCEPT_CONTENT_TYPE = "application/x-www-form-urlencoded,application/json,text/xml";
    static final String RESPONSE_ACCEPT_CONTENT_TYPE = "text/xml,text/plain,application/json";
    static final String SEPARATOR_STR = ",";

    public FilterUtils() {
    }

    public static boolean shouldTracer(HttpServletRequest request, HttpServletResponse response) {
        String responseContentType;
        String[] acceptContentTypes;
        String[] var5;
        int var6;
        int var7;
        String acceptContentType;
        if (null != request) {
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                return true;
            }

            responseContentType = request.getHeader("Content-Type");
            if (StrUtil.isNotEmpty(responseContentType)) {
                acceptContentTypes = "application/x-www-form-urlencoded,application/json,text/xml".split(",");
                var5 = acceptContentTypes;
                var6 = acceptContentTypes.length;

                for(var7 = 0; var7 < var6; ++var7) {
                    acceptContentType = var5[var7];
                    if (responseContentType.contains(acceptContentType)) {
                        return true;
                    }
                }
            }
        }

        if (null != response) {
            responseContentType = response.getContentType();
            if (StrUtil.isNotEmpty(responseContentType)) {
                acceptContentTypes = "text/xml,text/plain,application/json".split(",");
                var5 = acceptContentTypes;
                var6 = acceptContentTypes.length;

                for(var7 = 0; var7 < var6; ++var7) {
                    acceptContentType = var5[var7];
                    if (responseContentType.contains(acceptContentType)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

