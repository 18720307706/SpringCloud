package org.example.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import jdk.nashorn.internal.runtime.OptimisticBuiltins;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Lch on 2020/11/19
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInnerInterceptor(){
        return  new OptimisticLockerInterceptor();
    }
}