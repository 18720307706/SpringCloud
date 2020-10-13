package org.example.consumerFeign.controller;
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
public class ConsumerController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public  CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return  paymentFeignService.getPaymentById(id);
    }
}