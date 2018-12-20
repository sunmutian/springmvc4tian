package com.tian.service;

/**
 * @author teanvc
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getUserById(int userId) {
        System.out.println("userId=" + userId);
        return "teanvc userId=" + userId;
    }
}
