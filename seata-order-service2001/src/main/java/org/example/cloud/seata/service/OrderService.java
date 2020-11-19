package org.example.cloud.seata.service;

import org.example.cloud.seata.domain.Order;

/**
 * 业务层
 *
 * @author Lch on 2020/11/17
 */
public interface OrderService {
    void insert(Order order);

    void  update(Order order);
}