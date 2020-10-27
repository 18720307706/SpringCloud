package org.example.consumerFeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 *
 * @author Lch on 2020/10/13
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class ConsumerFeignMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignMain.class,args);
    }
}