package com.gsm.entity;

/**
 * 状态码
 */
public class StatusCode {
    //成功
    public static final int OK = 20000;
    //失败
    public static final int ERROR = 20001;
    //用户名或密码错误
    public static final int ERROR_LOGIN = 20002;
    //权限不足
    public static final int ERROR_ACCESS = 20003;
    //远程调用失败
    public static final int ERROR_REMOTE = 20004;
    //重复操作
    public static final int ERROR_REP = 20005;
}
