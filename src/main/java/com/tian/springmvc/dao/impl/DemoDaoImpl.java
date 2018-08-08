package com.tian.springmvc.dao.impl;

import com.tian.springmvc.annotation.Repository;
import com.tian.springmvc.dao.DemoDao;

/**
 * <p>
 * 模拟dao的实现
 *
 * @Author tianweichang
 * @Date 2018-08-08 10:45
 **/
@Repository("demoDao")
public class DemoDaoImpl implements DemoDao {
    @Override
    public void insert() {
        System.out.println("dao==============");
    }
}
