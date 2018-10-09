package com.tian.springbootdemo.service.impl;

import com.tian.springbootdemo.dao.domain.Goods;
import com.tian.springbootdemo.dao.mapper.GoodsDao;
import com.tian.springbootdemo.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 18
 * @Description:
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    @Override
    public Goods getUserById(int id) {
        return goodsDao.getUserById(id);
    }

    @Override
    public int updateUser(Goods goods) {
        System.out.println("update---" + goods);
        return goodsDao.updateUser(goods);
    }

    @Override
    public int insertUser(Goods goods) {
        return goodsDao.insertUser(goods);
    }

    @Override
    public int deleteUserById(int id) {
        return goodsDao.deleteUserById(id);
    }
}
