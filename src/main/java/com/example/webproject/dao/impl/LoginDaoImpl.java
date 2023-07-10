package com.example.webproject.dao.impl;

import com.example.webproject.common.LoginStatusCode;
import com.example.webproject.common.StatusCode;
import com.example.webproject.dao.LoginDao;
import com.example.webproject.pojo.User;
import com.example.webproject.util.DBUtil;

import static com.example.webproject.common.LoginStatusCode.*;

public class LoginDaoImpl implements LoginDao {

    public LoginStatusCode login(String name, String pwd) {
        String sql = "select * from user where name = ?;";
        User user = DBUtil.querySingle(sql, User.class, name);
        if (user == null) {
            return UNKNOWN_USER;
        }
        if (pwd.equals(user.getPwd())) {
            return LOGIN_SUCCESS;
        }
        return WRONG_PASSWORD;
    }

    @Override
    public StatusCode logout() {
        return null;
    }
}
