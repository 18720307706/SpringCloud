package org.example.cloud.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.example.cloud.seata.domain.Order;

/**
 * 订单Dao
 *
 * @author Lch on 2020/11/17
 */
@Mapper
public interface OrderDao {

    void insert(Order order);

    void  update(@Param("id") Long id);
}
