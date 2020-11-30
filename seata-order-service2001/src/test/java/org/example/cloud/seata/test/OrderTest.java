package org.example.cloud.seata.test;

import org.checkerframework.checker.units.qual.A;
import org.example.cloud.seata.domain.User;
import org.example.cloud.seata.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Lch on 2020/11/19
 */
@SpringBootTest
public class OrderTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void  order(){
//        List<User> users=userMapper.selectList(null);
//        users.forEach(System.out::println);
        Integer i=1;
        Integer s =1;
        System.out.println(i.equals(s));
    }
}