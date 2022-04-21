package com.royan.framework.core.constant;

public interface AuthConstants {


    /**
     * 认证请求头key
     */
    String AUTHORIZATION_KEY = "Authorization";

    /**
     * JWT令牌前缀
     */
    String AUTHORIZATION_PREFIX = "bearer ";


    /**
     * Basic认证前缀
     */
    String BASIC_PREFIX = "Basic ";

    /**
     * JWT载体key
     */
    String JWT_PAYLOAD_KEY = "payload";

    /**
     * JWT ID 唯一标识
     */
    String JWT_JTI = "jti";

    /**
     * JWT ID 唯一标识
     */
    String JWT_EXP = "exp";

    /**
     * Redis缓存权限规则key
     */
    String PERMISSION_ROLES_KEY = "auth:permission:roles";

    /**
     * 黑名单token前缀
     */
    String TOKEN_BLACKLIST_PREFIX = "auth:token:blacklist:";


    /**
     * 密码加密方式
     */
    String BCRYPT = "{bcrypt}";

    /**
     * 用户信息
     */
    String USER_INFO = "user";

    /**
     * JWT存储权限前缀
     */
    String AUTHORITY_PREFIX_KEY = "ROLE_";


    /**
     * JWT存储权限属性
     */
    String JWT_AUTHORITIES_KEY = "authorities";
    /**
     * 后台管理接口路径匹配
     */
    String AUTH_URL_PATTERN = "**/auth/**";


    String LOGOUT_PATH = "/api/auth/oauth/logout";


    String GRANT_TYPE_KEY = "grant_type";

    String REFRESH_TOKEN = "refresh_token";

    String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";
}
