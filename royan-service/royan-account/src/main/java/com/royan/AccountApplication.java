package com.royan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Qiurz
 * @version 1.0
 * @project royan-platform
 * @description
 * @date 2022/5/27 23:41:40
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

}
