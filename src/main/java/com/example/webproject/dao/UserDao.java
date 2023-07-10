package com.example.webproject.dao;

import com.example.webproject.common.StatusCode;
import com.example.webproject.pojo.User;
import com.example.webproject.util.DBUtil;

import java.util.List;

public interface UserDao {

    List<User> listAll();

    boolean exists(String name);

    StatusCode register(String name, String pwd);

    boolean delete(int uid);

    User getById(int uid);

    boolean update(String id, String password);
}
