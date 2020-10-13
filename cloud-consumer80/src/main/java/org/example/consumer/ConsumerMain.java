package org.example.consumer;

import org.example.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

import javax.naming.Name;

/**
 * 启动类
 *
 * @author Lch on 2020/9/9
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PAYMENT",configuration = MyRule.class)
public class ConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain.class,args);
    }
}