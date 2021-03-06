package org.example.payment.controller;

import lombok.extern.slf4j.Slf4j;

import org.example.api.entities.CommonResult;
import org.example.api.entities.Payment;
import org.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.hypermedia.DiscoveredResource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 控制器
 *
 * @author Lch on 2020/9/9
 */

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private  String serverPort;
    @Autowired
    private DiscoveryClient discoveryClient;
    @PostMapping("/payment/save")
    public CommonResult create(@RequestBody Payment payment){
         int result= paymentService.save(payment);
        log.info("****插入结果"+result);
         if (result>0){
             return  new CommonResult(200,"插入数据库成功!"+serverPort,result);
         }else {
             return  new CommonResult(500,"插入数据库失败!");
         }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id){
        Payment payment= paymentService.getPaymentById(id);
        log.info("****查询结果"+payment);
        if (payment!=null){
            return  new CommonResult(200,"查询数据库成功!"+serverPort,payment);
        }else {
            return  new CommonResult(500,"没有找到相应的数据!");
        }
    }
    @GetMapping("/payment/discovery")
    public  Object discovery(){
        List<String> list = discoveryClient.getServices();
        for (String s : list) {
                log.info("******element "+s);
        }
        List<ServiceInstance> instances= discoveryClient.getInstances("CLOUD-PAYMENT");
        instances.forEach(instance->{
            log.info("Id:"+instance.getServiceId()+"Host:"+instance.getHost()+"Port:"+instance.getPort()+"Uri:"+instance.getUri());
        });
        return  this.discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public  String getPayment(){
        return  serverPort;
    }
    @GetMapping("/payment/time")
    public  String paymentTime(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  serverPort;
    }
    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hello,zipkin";
    }
}