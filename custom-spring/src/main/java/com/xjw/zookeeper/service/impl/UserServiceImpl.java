package com.xjw.zookeeper.service.impl;

import com.xjw.zookeeper.dao.UserDao;
import com.xjw.zookeeper.dao.ZkServerInfoDao;
import com.xjw.zookeeper.entity.User;
import com.xjw.zookeeper.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 获取用户列表
     *
     * @param pageIndex
     * @param pageSize
     */
    @Override
    public List<User> getZkServerInfoByPage(int pageIndex, int pageSize) throws Exception {
        return userDao.getZkServerInfoByPage(pageIndex, pageSize);
    }

    /**
     * 通过id获取用户的信息
     *
     * @param id
     */
    @Override
    public User getUserInfoById(int id) throws Exception {
        return null;
    }

    /**
     * 添加一个用户信息
     *
     * @param user
     */
    @Override
    public int addUserInfo(User user) throws Exception {
        return userDao.addUserInfo(user);
    }

    /**
     * 通过id删除一个用户信息
     *
     * @param id
     */
    @Override
    public int delUserInfoById(int id) throws Exception {
        return 0;
    }

    /**
     * 更新一个用户信息
     *
     * @param user
     */
    @Override
    public int updUserInfo(User user) throws Exception {
        return 0;
    }

    /**
     * 通过userName获取用户的信息
     *
     * @param userName
     */
    @Override
    public List<User> getUserInfoByUserName(String userName) throws Exception {
        return userDao.getUserInfoByUserName(userName);
    }
}
