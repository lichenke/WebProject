package com.example.webproject.common;

public enum LoginStatusCode implements StatusCode{
    LOGIN_SUCCESS(10000, "登录成功"),
    UNKNOWN_USER(10001, "未知用户"),
    WRONG_PASSWORD(10002, "密码错误");

    private final int code;
    private final String msg;

    LoginStatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
