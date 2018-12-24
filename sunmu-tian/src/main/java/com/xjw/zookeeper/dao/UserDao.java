package com.xjw.zookeeper.dao;

import com.xjw.zookeeper.entity.User;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author tianweichang
 * @date 2018-12-11
 */
public interface UserDao {
    /**
     * 获取用户列表
     */
    List<User> getZkServerInfoByPage(int pageIndex, int pageSize) throws Exception;

    /**
     * 通过id获取用户的信息
     */
    User getUserInfoById(int id) throws Exception;

    /**
     * 添加一个用户信息
     */
    int addUserInfo(User user) throws Exception;

    /**
     * 通过id删除一个用户信息
     */
    int delUserInfoById(int id) throws Exception;

    /**
     * 更新一个用户信息
     */
    int updUserInfo(User user) throws Exception;
}
