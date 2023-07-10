package com.example.webproject.service;

import com.example.webproject.common.StatusCode;
import com.example.webproject.pojo.User;

import java.util.List;

public interface UserService {

    List<User> listAll();

    StatusCode register(String name, String pwd);

    boolean exists(String name);

    boolean delete(int id);

    User getById(int id);

    boolean update(String id, String password);
}
