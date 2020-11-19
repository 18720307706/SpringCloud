package org.example.cloud.seata.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"org.example.cloud.seata.dao"})
public class MyBatisConfig {

}

