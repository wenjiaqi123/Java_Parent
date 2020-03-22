package com.gsm.utils;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

/**
 * token 工具类
 */
@Component
public class TokenUtils {

    /**
     * 获得 Token
     */
    public static String getToken() {
        String token = IdUtil.simpleUUID();
        return token;
    }

    public static void main(String[] args) {
        String token = getToken();
        System.out.println(token);
    }
}
