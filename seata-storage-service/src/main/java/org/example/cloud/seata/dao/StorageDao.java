package org.example.cloud.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.cloud.seata.domain.Storage;


/**
 * 订单Dao
 *
 * @author Lch on 2020/11/17
 */
@Mapper
public interface StorageDao {

    void insert(Storage storage);

    void  update(@Param("productId") Long productId,@Param("count") Integer count);
}
