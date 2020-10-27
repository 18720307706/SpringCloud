package org.example.payment.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.example.payment.service.PaymentService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * 接口实现类
 *
 * @author Lch on 2020/9/9
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentOk(Long id) {
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"访问成功";
    }

    /**
     * 服务降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentTimeOut",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    @Override
    public String paymentOut(Long id) {
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"访问成功~但耗时1秒";
    }

    @Override
    public String paymentTimeOut(Long id) {
        return "线程池："+Thread.currentThread().getName()+"系统或者运行报错,请稍后再试,id:"+id;
    }

    /**
     * 服务熔断
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerOut",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value ="10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw  new RuntimeException("id不能为负数");
        }
        String serialNumber= IdUtil.simpleUUID();
        return   Thread.currentThread().getName()+"调用成功,流水号："+serialNumber;
    }
    public  String paymentCircuitBreakerOut(@PathVariable("id") Integer id){
        return "id不能为负数,请稍后再试,id："+id;
    }
}