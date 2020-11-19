package org.example.cloud.seata.countroller;

import org.example.api.entities.CommonResult;
import org.example.cloud.seata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Lch on 2020/11/17
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PutMapping("/decrease")
    public CommonResult update(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money){

        accountService.update(userId,money);
        return  new CommonResult(200,"扣除金额成功成功");
    }
}