package org.example.consumer.controller;

import lombok.extern.slf4j.Slf4j;

import org.example.api.entities.CommonResult;
import org.example.api.entities.Payment;
import org.example.consumer.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * 订单
 *
 * @author Lch on 2020/9/9
 */
@RestController
@Slf4j
public class ConsumerController {
    public  static  final  String PAYMENT_KEY="http://CLOUD-PAYMENT";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;
    @PostMapping("/consumer/save")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return  restTemplate.postForObject(PAYMENT_KEY+"/payment/save",payment, CommonResult.class);
    }
    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id ){
        return  restTemplate.getForObject(PAYMENT_KEY+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping("/consumer/getEntity/{id}")
    public CommonResult<Payment> getEntity(@PathVariable("id") Long id ){
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_KEY+"/payment/get/"+id,CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            return  responseEntity.getBody();
        }
            return new CommonResult<>(500,"操作失败");
    }
    @GetMapping(value =  "/consumer/payment/lb")
    public  String getPaymentLB(){
        List<ServiceInstance> list= discoveryClient.getInstances("CLOUD-PAYMENT");
        if (list==null || list.size()<=0){
                return  null;
        }
         ServiceInstance serviceInstance = loadBalancer.instances(list);
        URI uri= serviceInstance.getUri();
        return  restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}