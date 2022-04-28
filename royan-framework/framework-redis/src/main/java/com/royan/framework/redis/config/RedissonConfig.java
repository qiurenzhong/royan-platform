package com.royan.framework.redis.config;

import cn.hutool.core.convert.Convert;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author Qiurz
 * @version 1.0
 * @project royan-platform
 * @description Redisson的配置类
 * @date 2022/4/28 22:11:17
 */
@Configuration
public class RedissonConfig {

    @Autowired
    private Environment env;

    /**
     * Redisson客户端注册
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient createRedissonClient() {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://" + env.getProperty("spring.redis.host") + env.getProperty("spring.redis.port"));
        singleServerConfig.setTimeout(Convert.toInt(env.getProperty("spring.redis.timeout")));
        return Redisson.create(config);
    }

}
