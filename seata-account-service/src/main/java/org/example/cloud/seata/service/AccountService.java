package org.example.cloud.seata.service;

import feign.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Lch on 2020/11/17
 */
public interface AccountService {
    void update(@RequestParam("userId") Long userId, @RequestParam("money")  BigDecimal money);
}