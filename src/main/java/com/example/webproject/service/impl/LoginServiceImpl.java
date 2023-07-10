package com.example.webproject.service.impl;

import com.example.webproject.common.StatusCode;
import com.example.webproject.dao.LoginDao;
import com.example.webproject.dao.impl.LoginDaoImpl;
import com.example.webproject.service.LoginService;

public class LoginServiceImpl implements LoginService {

    LoginDao loginDao = new LoginDaoImpl();

    @Override
    public StatusCode login(String name, String pwd) {
        return loginDao.login(name, pwd);
    }

    @Override
    public StatusCode logout() {
        return null;
    }
}
