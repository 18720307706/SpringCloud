package org.example.cloud.seata.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.example.cloud.seata.dao.OrderDao;
import org.example.cloud.seata.domain.Order;
import org.example.cloud.seata.service.AccountService;
import org.example.cloud.seata.service.OrderService;
import org.example.cloud.seata.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 实现类
 *
 * @author Lch on 2020/11/17
 */


@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private  IdGeneratorSnowflake idGeneratorSnowflake;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AccountService accountService;
    @Autowired
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "lch-create-order", rollbackFor = Exception.class)
    public void insert(Order order) {
        log.info("开始创建订单");
        orderDao.insert(order);
        log.info("调库存做减法");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("调用户账号做减法");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("改订单状态");
        orderDao.update(order.getId());
        log.info("下单结束");
    }

    @Override
    public void update(Order order) {

    }
}