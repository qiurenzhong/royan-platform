package com.royan.framework.api.web.exception;

import com.royan.framework.api.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *  全局异常处理
 * @author Qiurz
 * @date 2021/4/18
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseData handleException(Exception e) {
        return ResponseData.failed(e.getMessage());
    }

}
