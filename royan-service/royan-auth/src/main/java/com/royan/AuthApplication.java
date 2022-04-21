package com.royan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author Qiurz
 * @date 2021/4/7 12:33
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
        System.out.println("\nroyan-auth服务启动成功\n\n" + str);
    }

    static String str = "-------------------- royan-auth 示例 --------------------\n\n" +
            "http://loaclhost:21402";
}
