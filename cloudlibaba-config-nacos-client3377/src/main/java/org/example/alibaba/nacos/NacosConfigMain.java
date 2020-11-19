package org.example.alibaba.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 *
 * @author Lch on 2020/11/5
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigMain {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigMain.class,args);
    }
}