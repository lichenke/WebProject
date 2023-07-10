package com.example.webproject.service;

import com.example.webproject.common.StatusCode;

public interface LoginService {

    StatusCode login(String name, String pwd);

    StatusCode logout();

}
