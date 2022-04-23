package com.royan.framework.core.exception;

import com.royan.framework.api.entity.AppCode;

/**
 * @author Qiurz
 * @date 2020/4/12
 */
public class ApplicationException extends RuntimeException {

    private AppCode appCode;

    public ApplicationException() {
    }

    public ApplicationException(AppCode appCode) {
        super(appCode.getMessage());
        this.appCode = appCode;
    }

    public ApplicationException(AppCode appCode, Object... msgArgs) {
        super(String.format(appCode.getMessage(), msgArgs));
        this.appCode = appCode;
    }

    public ApplicationException(String code, String message) {
        this(code, message, (Throwable)null);
    }

    public ApplicationException(String code, String message, Throwable cause) {
        super(message, cause);
        this.appCode = new DefaultAppCode(code, message);
    }

    static class DefaultAppCode implements AppCode {
        private String code;
        private String message;

        public DefaultAppCode(String code, String message) {
            this.setCode(code);
            this.setMessage(message);
        }

        @Override
        public String getCode() {
            return this.code;
        }

        @Override
        public void setCode(String code) {
            this.code = code;
        }

        @Override
        public String getMessage() {
            return this.message;
        }

        @Override
        public void setMessage(String message) {
            this.message = message;
        }
    }
}
