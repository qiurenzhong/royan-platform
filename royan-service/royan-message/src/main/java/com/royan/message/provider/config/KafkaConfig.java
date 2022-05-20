package com.royan.message.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

/**
 * @author Qiurz
 * @version 1.0
 * @project royan-platform
 * @description kafka配置类
 * @date 2022/5/18 12:23:04
 */
public class KafkaConfig {

    // 创建一个名为royan_kafka_test_topic，并设置分区8，副本数2

    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("royan_kafka_test_topic", 8, (short) 2);
    }

    // 如果要修改分区数，只需修改配置值重启项目即可
    // 修改分区数并不会导致数据的丢失，但是分区数只能增大不能减小
    @Bean
    public NewTopic updateTopic() {
        return new NewTopic("royan_kafka_test_topic", 10, (short) 2);
    }
}
