package org.example.payment.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import javafx.beans.DefaultProperty;
import lombok.extern.slf4j.Slf4j;
import org.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Lch on 2020/10/26
 */
@RestController
@Slf4j

public class PaymentHystrixController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public  String paymentInfoOk(@PathVariable("id") Long id){
        String result =paymentService.paymentOk(id);
        return  result;
    }
    @GetMapping("/payment/hystrix/out/{id}")
    public  String paymentInfoOut(@PathVariable("id") Long id){
        String result =paymentService.paymentOut(id);
        return  result;
    }
    @GetMapping("/payment/hystrix/Circuit/{id}")
    public  String paymentInfoOut(@PathVariable("id") Integer id){
        String result =paymentService.paymentCircuitBreaker(id);
        return  result;
    }
}