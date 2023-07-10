package com.example.webproject.dao;

import com.example.webproject.common.StatusCode;

public interface LoginDao {

    StatusCode login(String name, String pwd);

    StatusCode logout();
}
