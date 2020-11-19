package org.example.cloud.seata.service;

import org.example.api.entities.CommonResult;
import org.example.cloud.seata.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Lch on 2020/11/17
 */


@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PutMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}