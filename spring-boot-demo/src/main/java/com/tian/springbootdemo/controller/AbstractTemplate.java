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
        //第一步：解析参数
        parseRequestParameters();
        //第二步：校验参数
        checkRequestParameters();
        //第三步：业务处理
        Object data = doBusiness();
        //第四步：组织返回参数
        return assembleResponseParameters(data);
    }

    /**
     * 解析参数
     */
    protected void parseRequestParameters() {
        System.out.println("AbstractTemplate 解析参数");
    }

    /**
     * 校验参数
     * 也可以在实现类里加以扩展
     */
    protected void checkRequestParameters() {
        System.out.println("AbstractTemplate 校验参数");
    }

    /**
     * 业务处理
     */
    protected abstract Object doBusiness();

    /**
     * 组织返回参数
     */
    protected abstract Result assembleResponseParameters(Object object);
}
