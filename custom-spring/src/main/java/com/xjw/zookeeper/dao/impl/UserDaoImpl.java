package com.xjw.zookeeper.dao.impl;

import com.xjw.zookeeper.dao.UserDao;
import com.xjw.zookeeper.entity.User;
import com.xjw.zookeeper.entity.ZkServerInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 获取用户列表
     *
     * @param pageIndex
     * @param pageSize
     */
    @Override
    public List<User> getZkServerInfoByPage(int pageIndex, int pageSize) throws Exception {
        final List<User> users = new ArrayList<User>();
        jdbcTemplate.query("select * from t_user", new Object[]{}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                User user;
                do {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setPassWord(rs.getString("password"));
                    users.add(user);
                } while (rs.next());
            }
        });
        return users;
    }

    /**
     * 通过id获取用户的信息
     *
     * @param id
     */
    @Override
    public User getUserInfoById(int id) throws Exception {
        final User user = new User();
        jdbcTemplate.query("select * from t_user WHERE id=?", new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                do {
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setPassWord(rs.getString("password"));
                } while (rs.next());
            }
        });
        return user;
    }

    /**
     * 通过userName获取用户的信息
     *
     * @param userName
     */
    @Override
    public List<User> getUserInfoByUserName(String userName) throws Exception {
        final List<User> users = new ArrayList<User>();
        jdbcTemplate.query("select * from t_user WHERE user_name=?", new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                User user;
                do {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setPassWord(rs.getString("password"));
                    users.add(user);
                } while (rs.next());
            }
        });
        return users;
    }

    /**
     * 添加一个用户信息
     *
     * @param user
     */
    @Override
    public int addUserInfo(User user) throws Exception {
        return 0;
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
}
