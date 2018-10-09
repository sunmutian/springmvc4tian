package com.tian.springbootdemo.dao.mapper;

import com.tian.springbootdemo.dao.domain.Goods;
import com.tian.springbootdemo.dao.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 17:11
 * @Description:
 */

@Mapper//加上该注解才能使用@MapperScan扫描到
public interface GoodsDao {

    Goods getUserById(@Param("id") int id);

    int updateUser(@Param("gs") Goods user);

    int insertUser(@Param("gs") Goods user);

    int deleteUserById(@Param("id") int id);
}