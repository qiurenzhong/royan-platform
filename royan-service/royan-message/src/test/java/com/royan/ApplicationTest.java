package com.royan;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author Qiurz
 * @version 1.0
 * @project royan-platform
 * @description 模拟一键快速启动kafka server
 * @date 2022/5/18 11:40:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
@EmbeddedKafka(count = 4, ports = {9092, 9093, 9094, 9095}, brokerProperties = {"log.index.interval.bytes = 4096", "num.io.threads = 8"})
public class ApplicationTest {

    @Test
    public void contextLoads() throws IOException {
        System.in.read();
    }
}
