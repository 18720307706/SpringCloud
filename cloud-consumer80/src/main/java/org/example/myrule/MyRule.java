package org.example.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 改变规则
 *
 * @author Lch on 2020/9/14
 */
@Configuration
public class MyRule {
    // 定义位随机方式
    @Bean
    public IRule myRules(){
        return  new RandomRule();
    }
}