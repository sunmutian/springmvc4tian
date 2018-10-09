package com.tian;

/**
 * @author tianweichang
 * @date 2018-09-27 9:24
 **/
public class Student {
    private int userId;
    private String name;
    private int age;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }
}
