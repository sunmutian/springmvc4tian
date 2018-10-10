package com.tian.springbootdemo.dao.domain;

import java.io.Serializable;

/**
 * @auther: lawt
 * @date: 2018/9/8 17
 * @Description:
 */
public class User implements Serializable {
    private Integer id;

    private String name;

    private String sex;

    private int age;

    public User() {
    }

    public User(Integer id, String name, String sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
