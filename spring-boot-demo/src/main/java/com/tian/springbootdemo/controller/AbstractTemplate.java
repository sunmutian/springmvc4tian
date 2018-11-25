package com.tian.springbootdemo.controller;

import com.tian.springbootdemo.rep.Result;

/**
 * @auther: 小田哥
 * @date: 2018/11/17 09
 * @Description: 模板类
 */
public abstract class AbstractTemplate {

    /**
     * 算法骨架
     */
    public Result execute() {
        parseRequestParameters();
        checkRequestParameters();
        Object object= doBusiness();
        return assembleResponseParameters(object);
    }

    /**
     * 解析参数
     */
    public abstract void parseRequestParameters();

    /**
     * 校验参数
     */
    public abstract void checkRequestParameters();

    /**
     * 业务处理
     */
    public abstract Object doBusiness();

    /**
     * 组织返回参数
     */
    public abstract Result assembleResponseParameters(Object object);
}
