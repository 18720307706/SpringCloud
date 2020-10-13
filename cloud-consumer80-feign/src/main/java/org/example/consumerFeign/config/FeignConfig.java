package org.example.consumerFeign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志配置类
 *
 * @author Lch on 2020/10/13
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feign(){
        return  Logger.Level.FULL;
    }
}