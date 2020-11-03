package org.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置
 *
 * @author Lch on 2020/10/30
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain.class,args);
    }

}