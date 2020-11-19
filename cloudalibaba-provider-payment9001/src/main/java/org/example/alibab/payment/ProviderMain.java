package org.example.alibab.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主启动类
 *
 * @author Lch on 2020/11/3
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderMain {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain.class,args);
    }
}