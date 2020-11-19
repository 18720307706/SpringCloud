package org.example.cloud.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 实体类
 *
 * @author Lch on 2020/11/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage  {
    private  Long id;
    private  Long productId;
    private  Integer total;
    private  Integer used;
    private  Integer residue;
}