package org.example.cloud.seata.controller;

import org.example.api.entities.CommonResult;
import org.example.cloud.seata.domain.Order;
import org.example.cloud.seata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lch on 2020/11/17
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/inster")
    public CommonResult inster( @RequestBody  Order order){
        orderService.insert(order);
        return new CommonResult(200,"创建订单成功");
    }
}