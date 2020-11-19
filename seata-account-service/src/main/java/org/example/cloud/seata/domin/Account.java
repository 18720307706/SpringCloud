package org.example.cloud.seata.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类
 *
 * @author Lch on 2020/11/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private  Long id;
    private  Long userId;
    private  Integer total;
    private  Integer used;
    private  Integer residue;
}