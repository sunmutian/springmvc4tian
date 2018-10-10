package com.tian.springbootdemo.vo;

import java.io.Serializable;

/**
 * @auther: lawt
 * @date: 2018/10/9 21
 * @Description:
 */
public class ResObject implements Serializable{
    private int value;
    private Object object;

    public ResObject() {
    }

    public ResObject(int value, Object object) {
        this.value = value;
        this.object = object;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
