package org.example.cloud.seata.controller;

import org.example.api.entities.CommonResult;
import org.example.cloud.seata.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lch on 2020/11/17
 */
@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    private StorageService storageService;
    @PutMapping("/decrease")
    public CommonResult updata(@RequestParam("productId") Long productId , @RequestParam("count") Integer count){
        storageService.update(productId,count);
        return  new CommonResult(200,"修改订单库存成功!");
    }
}