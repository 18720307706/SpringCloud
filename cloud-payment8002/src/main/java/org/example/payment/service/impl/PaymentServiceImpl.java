package org.example.payment.service.impl;

import org.example.api.entities.Payment;
import org.example.payment.dao.PaymentDao;
import org.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 接口实现类
 *
 * @author Lch on 2020/9/9
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return  paymentDao.getPaymentById(id);
    }
}