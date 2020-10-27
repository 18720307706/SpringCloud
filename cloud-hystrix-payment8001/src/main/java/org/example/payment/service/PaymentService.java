package org.example.payment.service;

import org.apache.ibatis.annotations.Param;
import org.example.api.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * pay接口
 *
 * @author Lch on 2020/9/9
 */
public interface PaymentService {
      /**
       * 方法OK
       * @param id
       * @return
       */
      public  String paymentOk(Long id);

      /**
       * 方法失败
       * @param id
       * @return
       */
      public  String paymentOut(Long id);
      /**
       * 方法失败
       * @param id
       * @return
       */
      public  String paymentTimeOut(Long id);

      public String paymentCircuitBreaker(Integer id);
}
