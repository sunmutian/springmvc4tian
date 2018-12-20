package com.tian.service;

/**
 * @author lawt
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getUserById(int userId) {
        System.out.println("userId=" + userId);
        return "teanvc userId=" + userId;
    }
}
