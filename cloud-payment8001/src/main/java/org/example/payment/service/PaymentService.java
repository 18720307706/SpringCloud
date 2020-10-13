package org.example.payment.service;

import org.apache.ibatis.annotations.Param;
import org.example.api.entities.Payment;


/**
 * pay接口
 *
 * @author Lch on 2020/9/9
 */
public interface PaymentService {
      int save(Payment payment);
      Payment getPaymentById(@Param("id") Long id);
}