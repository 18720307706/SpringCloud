package org.example.cloud.seata.service;

import org.apache.ibatis.annotations.Param;

/**
 * 实体类
 *
 * @author Lch on 2020/11/17
 */
public interface StorageService {
    void  update(@Param("productId") Long productId, @Param("count") Integer count);
}