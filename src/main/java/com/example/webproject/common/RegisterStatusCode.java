package com.example.webproject.common;

public enum RegisterStatusCode implements StatusCode {

    REGISTER_SUCCESS(20000, "注册成功"),

    USER_ALREADY_EXISTS(20001, "用户已存在"),

    REGISTER_FAILED(20002, "注册失败");


    private final int code;
    private final String msg;

    RegisterStatusCode(int code, String msg) {
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
