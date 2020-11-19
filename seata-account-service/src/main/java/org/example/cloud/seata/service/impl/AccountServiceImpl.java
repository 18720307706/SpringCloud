package org.example.cloud.seata.service.impl;

import org.example.cloud.seata.dao.AccountDao;
import org.example.cloud.seata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Lch on 2020/11/17
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void update(Long userId, BigDecimal money) {
        accountDao.update(userId,money);
    }
}