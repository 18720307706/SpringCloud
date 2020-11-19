package org.example.cloud.seata.dao;

import feign.Param;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

/**
 * @author Lch on 2020/11/17
 */
@Mapper
public interface AccountDao {
     void update(@Param("userId") Long userId, @Param("money") BigDecimal money);
}