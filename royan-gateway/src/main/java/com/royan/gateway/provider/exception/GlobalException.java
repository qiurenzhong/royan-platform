package com.royan.gateway.provider.exception;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.royan.framework.api.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalException {

    @ResponseBody
    @ExceptionHandler
    public ResponseData handlerException(Exception e) {

        log.error(e.getMessage(), e);

        if (e instanceof NotLoginException) {
            NotLoginException notLoginException = (NotLoginException) e;
            return ResponseData.failed(notLoginException.getMessage());
        } else if (e instanceof NotRoleException) {        // 如果是角色异常
            NotRoleException ee = (NotRoleException) e;
            return ResponseData.failed("无此角色：" + ee.getRole());
        } else if (e instanceof NotPermissionException) {    // 如果是权限异常
            NotPermissionException ee = (NotPermissionException) e;
            return ResponseData.failed("无此权限：" + ee.getCode());
        } else if (e instanceof DisableLoginException) {    // 如果是被封禁异常
            DisableLoginException ee = (DisableLoginException) e;
            return ResponseData.failed("账号被封禁：" + ee.getDisableTime() + "秒后解封");
        } else {    // 普通异常, 输出：500 + 异常信息
            return ResponseData.failed(e.getMessage());
        }
    }
}
