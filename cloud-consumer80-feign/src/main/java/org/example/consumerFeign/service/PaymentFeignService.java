package org.example.consumerFeign.service;
import org.example.api.entities.CommonResult;
import org.example.api.entities.Payment;
import org.example.consumerFeign.service.impl.PaymentFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 接口
 *
 * @author Lch on 2020/10/13
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT",fallback = PaymentFallbackServiceImpl.class)
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
     CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    @GetMapping("/payment/time")
    String paymentTime();
    @GetMapping("/payment/hystrix/out/{id}")
    String  paymentOut(@PathVariable("id") Long id);
}