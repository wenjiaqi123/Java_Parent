package com.gsm.entity;

import java.util.HashMap;
import java.util.Map;

public class RespCodeMsg{

    public static Map<Integer, String> map = new HashMap<Integer, String>() {
        private static final long serialVersionUID = -5818977994609761432L;
        {
            put(20000,"成功");
            put(20001,"失败");
            put(20002,"用户名或密码错误");
            put(20003,"权限不足");
            put(20004,"远程调用失败");
            put(20005,"重复操作");
        }
    };
}
