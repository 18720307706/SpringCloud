package org.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import javax.security.auth.login.Configuration;

/**
 * 配置主启动类
 *
 * @author Lch on 2020/10/29
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain.class,args);
    }
}