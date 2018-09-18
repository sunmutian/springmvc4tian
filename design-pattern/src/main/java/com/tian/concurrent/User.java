package com.tian.concurrent;

/**
 * @author tianweichang
 * @date 2018-09-18 13:56
 **/
public class User {
    private String name;
    private String pwd;
    private String gender;
    private int age;

    public User(String name, String pwd, String gender, int age) {
        this.name = name;
        this.pwd = pwd;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
