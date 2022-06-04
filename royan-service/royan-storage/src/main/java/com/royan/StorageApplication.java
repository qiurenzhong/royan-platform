package com.royan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Qiurz
 * @version 1.0
 * @project royan-platform
 * @description
 * @date 2022/5/27 23:41:40
 */
@EnableDiscoveryClient
@SpringBootApplication
public class StorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }

}
