package com.tian.springbootdemo.dao.domain;

import java.io.Serializable;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 18
 * @Description:
 */
public class Goods implements Serializable {
    private Integer id;
    private Integer count;
    private String name;
    private String version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
