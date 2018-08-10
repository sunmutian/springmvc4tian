package com.tian.springmvc.service.impl;

import com.tian.springmvc.annotation.Qualifier;
import com.tian.springmvc.annotation.Service;
import com.tian.springmvc.dao.DemoDao;
import com.tian.springmvc.service.DemoService;

/**
 * <p>
 * TODO
 *
 * @Author tianweichang
 * @Date 2018-08-08 10:46
 **/
@Service("demoService")
public class DemoServiceImpl implements DemoService {
    @Qualifier("demoDao")
    private DemoDao demoDao;

    @Override
    public void insert() {
        System.out.println("service start-------------------");
        demoDao.insert();
        System.out.println("service end-------------------");
    }
}
