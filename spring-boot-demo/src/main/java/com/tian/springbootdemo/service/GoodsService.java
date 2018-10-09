package com.tian.springbootdemo.service;

import com.tian.springbootdemo.dao.domain.Goods;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 18:24
 * @Description:
 */
public interface GoodsService {
    Goods getUserById(int id);

    int updateUser(Goods user);

    int insertUser(Goods user);

    int deleteUserById(int id);
}
