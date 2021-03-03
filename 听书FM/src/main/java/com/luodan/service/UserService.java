package com.luodan.service;

import com.luodan.dao.UserDao;
import com.luodan.model.User;

import java.sql.SQLException;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/2/6 22:56
 */
/*
提供偏向业务角度的方法
 */
public class UserService {
    private UserDao userDao;
    public UserService() {
        userDao = new UserDao();
    }

    public User register(String username,String password) throws SQLException {
        return userDao.insert(username,password);
    }

    public User login(String username,String password) throws SQLException {
        return userDao.select(username,password);
    }
}
