package org.example.cloud.seata.service;

import org.example.api.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 业务实现类
 *
 * @author Lch on 2020/11/17
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PutMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}