package org.example.mybatis.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis.domain.User;


/**
 * @author Lch on 2020/11/19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


}