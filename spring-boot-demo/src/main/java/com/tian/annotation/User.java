package com.tian.annotation;

public class User {
    @MyAnnotation
    private String userName="111111111111";

    public String getUserName() {
        return this.userName;
    }
}
