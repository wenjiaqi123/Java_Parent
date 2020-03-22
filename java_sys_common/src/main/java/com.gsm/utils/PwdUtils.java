package com.gsm.utils;

import cn.hutool.core.codec.Base64;
import org.springframework.stereotype.Component;

/**
 * 密码加密解密
 * 123456      ->       MTIzNDU2        ->      TVRJek5EVTI=
 * 111111      ->       MTExMTEx        ->      TVRFeE1URXg=
 */
@Component
public class PwdUtils {

    /**
     * 使用 base64 加密
     * @param str 需要加密的明文
     * @return 密文
     */
    public static String base64Encode(String str){
        String s = Base64.encode(str);
        return s;
    }

    /**
     * 使用 base64 解密
     * @param str Base64加密的密文
     * @return 明文
     */
    public static String base64Decode(String str){
        String s = Base64.decodeStr(str);
        return s;
    }

    public static void main(String[] args) {
        String s = base64Encode("MTExMTEx");
        System.out.println(s);
    }
}
