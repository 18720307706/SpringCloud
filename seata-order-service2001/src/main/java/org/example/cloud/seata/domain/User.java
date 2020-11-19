package org.example.cloud.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 *
 * @author Lch on 2020/11/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  Long id;
    private  String name;
    private  Integer age;
    private  String email;
}