package com.tian.springmvc.controller;

/**
 * 模模板类
 *
 * @Author tianweichang
 * @Date 2018-08-10 15:17
 **/
public abstract class AbstractTemplate {
    /**
     * 执行流程
     */
    public void execute() {
        parseRequestParameters();
        checkParameters();
        doBusiness();
        assembleResponseParameters();
    }
    /**
     * 参数检查
     */
    protected abstract void checkParameters();
    /**
     * 解析参数
     */
    protected abstract void parseRequestParameters();
    /**
     * 业务处理
     */
    protected abstract void doBusiness();
    /**
     * 组装相应参数
     */
    protected abstract void assembleResponseParameters();
}
