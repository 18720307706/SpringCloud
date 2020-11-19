package org.example.cloud.seata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.cloud.seata.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lch on 2020/11/19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


}