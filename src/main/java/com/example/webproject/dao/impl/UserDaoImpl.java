package com.example.webproject.dao.impl;

import com.example.webproject.common.StatusCode;
import com.example.webproject.dao.UserDao;
import com.example.webproject.pojo.User;
import com.example.webproject.util.DBUtil;

import java.util.List;

import static com.example.webproject.common.RegisterStatusCode.*;

public class UserDaoImpl implements UserDao {

    public List<User> listAll() {
        String sql = "select * from user;";
        return DBUtil.query(sql, User.class);
    }

    @Override
    public boolean exists(String name) {
        String check = "select exists(select 1 from user where name = ?) as exist";
        Long res = DBUtil.queryScalar(check, name);
        return res == 1L;
    }


    @Override
    public StatusCode register(String name, String pwd) {
        String check = "select exists(select 1 from user where name = ?) as exist";
        Long res = DBUtil.queryScalar(check, name);
        if (res == 1L) {
            return USER_ALREADY_EXISTS;
        }
        String insert = "insert into user (name, pwd) values (?, ?);";
        int aff = DBUtil.update(insert, name, pwd);
        if (aff == 1) {
            return REGISTER_SUCCESS;
        } else {
            return REGISTER_FAILED;
        }
    }

    @Override
    public boolean delete(int uid) {
        String delete = "delete from user where id = ?";
        int res = DBUtil.update(delete, uid);
        return res == 1;
    }

    @Override
    public User getById(int uid) {
        String get = "select * from user where id = ?";
        return DBUtil.querySingle(get, User.class, uid);
    }

    @Override
    public boolean update(String id, String password) {
        String update = "update user set pwd = ? where id = ?";
        int res = DBUtil.update(update, password, id);
        return res == 1;
    }


}
