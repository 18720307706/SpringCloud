package org.example.consumerFeign.service.impl;

import org.example.api.entities.CommonResult;
import org.example.api.entities.Payment;
import org.example.consumerFeign.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * 全剧处理类
 *
 * @author Lch on 2020/10/26
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentFeignService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return null;
    }

    @Override
    public String paymentTime() {
        return null;
    }

    @Override
    public String paymentOut(Long id) {
        return "paymentOut全局处理错误";
    }
}