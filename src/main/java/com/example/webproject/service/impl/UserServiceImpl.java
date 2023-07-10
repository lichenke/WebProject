package com.example.webproject.service.impl;


import com.example.webproject.common.StatusCode;
import com.example.webproject.dao.UserDao;
import com.example.webproject.dao.impl.UserDaoImpl;
import com.example.webproject.pojo.User;
import com.example.webproject.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    public List<User> listAll() {
        return userDao.listAll();
    }

    public StatusCode register(String name, String pwd) {
        return userDao.register(name, pwd);
    }

    @Override
    public boolean exists(String name) {
        return userDao.exists(name);
    }

    @Override
    public boolean delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public boolean update(String id, String password) {
        return userDao.update(id, password);
    }


}
