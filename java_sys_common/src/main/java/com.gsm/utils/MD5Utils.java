package com.gsm.utils;

import cn.hutool.crypto.SecureUtil;
import org.springframework.stereotype.Component;

/**
 * MD5 工具类
 * 123456   ->  e10adc3949ba59abbe56e057f20f883e  ->       14e1b600b1fd579f47433b88e8d85291
 * 111111   ->  96e79218965eb72c92a549dd5a330112  ->       9db06bcff9248837f86d1a6bcf41c9e7
 */
@Component
public class MD5Utils {

    /**
     * MD5 加密
     * @param str
     * @return
     */
    public static String getMD5(String str){
        String md5 = SecureUtil.md5("96e79218965eb72c92a549dd5a330112");
        return md5;
    }

    public static void main(String[] args) {
        String md5 = getMD5("96e79218965eb72c92a549dd5a330112");
        System.out.println(md5);
    }
}
