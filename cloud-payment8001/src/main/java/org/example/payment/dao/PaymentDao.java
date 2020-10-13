package org.example.payment.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.api.entities.Payment;


/**
 * 交易接口
 *
 * @author Lch on 2020/9/7
 */
@Mapper
public interface PaymentDao{
    int save(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}