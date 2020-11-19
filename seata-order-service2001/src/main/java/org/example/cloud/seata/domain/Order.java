package org.example.cloud.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 订单实体类
 *
 * @author Lch on 2020/11/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order  {
    private  Long id;
    private  Long userId;
    private  Long productId;
    private  Integer count;
    private  BigDecimal money;
    private  Integer status;
}