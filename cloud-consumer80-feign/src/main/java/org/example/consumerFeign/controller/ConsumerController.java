package org.example.consumerFeign.controller;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.example.api.entities.CommonResult;
import org.example.api.entities.Payment;
import org.example.consumerFeign.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 订单
 *
 * @author Lch on 2020/9/9
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentTimeOut")
public class ConsumerController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public  CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return  paymentFeignService.getPaymentById(id);
    }
    @GetMapping("/consumer/payment/time")
     public  String paymentTime(){
        return  paymentFeignService.paymentTime();
    }

    @GetMapping("/consumer/payment/out/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOut",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
//    @HystrixCommand
    public  String paymentOut(@PathVariable("id") Long id){
        return paymentFeignService.paymentOut(id);
    }
    public String paymentTimeOut() {
        return "消费者："+Thread.currentThread().getName()+"系统或者运行报错,请稍后再试,id:";
    }
    public String paymentTimes(@PathVariable("id")Long id) {
        return "全局降级";
    }
}