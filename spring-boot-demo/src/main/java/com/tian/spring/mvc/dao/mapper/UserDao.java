package com.tian.spring.mvc.dao.mapper;

import com.tian.spring.mvc.dao.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 17:11
 * @Description:
 */

@Mapper//加上该注解才能使用@MapperScan扫描到
public interface UserDao {

    User getUserById(@Param("id") int id);

    int updateUser(@Param("user") User user);

    int insertUser(@Param("user") User user);

    int deleteUserById(@Param("id") int id);
}