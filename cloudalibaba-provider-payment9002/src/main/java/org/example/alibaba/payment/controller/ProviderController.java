package org.example.alibaba.payment.controller;

import org.example.api.entities.CommonResult;
import org.example.api.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Lch on 2020/11/3
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private  String serverPort;
    public  static HashMap<Long,Payment> hashMap= new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"1号订单"));
        hashMap.put(2L,new Payment(2L,"2号订单"));
        hashMap.put(3L,new Payment(3L,"3号订单"));
    }
    @GetMapping(value = "/payment/nacos/{id}")
    public  String getPaymentId(@PathVariable("id") Integer id ){
        return "端口号:"+serverPort+"id:"+id;
    }
    @GetMapping(value = "/payment/{id}")
    public  CommonResult<Payment> getId(@PathVariable("id") Long id ){
        return  new CommonResult(200,serverPort,hashMap.get(id));
    }
}