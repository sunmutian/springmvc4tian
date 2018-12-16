package com.tian.bean;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @auther: tianweichang
 * @date: 2018/12/15 23
 * @Description: 请求参数
 */
public class Request implements Serializable {
    /**
     * 类名称
     */
    private String className;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 参数类型
     */
    private Class<?>[] types;
    /**
     * 参数
     */
    private Object[] params;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getTypes() {
        return types;
    }

    public void setTypes(Class<?>[] types) {
        this.types = types;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Request{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", types=" + Arrays.toString(types) +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}
