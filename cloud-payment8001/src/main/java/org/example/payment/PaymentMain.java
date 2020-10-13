package org.example.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * pay业务启动类
 *
 * @author Lch on 2020/9/7
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain.class,args);
    }
}