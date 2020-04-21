package com.gsm.utils;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

/**
 * uuid 工具类
 */
@Component
public class UUIDUtils {

    /**
     * 获得 Token
     */
    public static String getUUID() {
        String uuid = IdUtil.simpleUUID();
        return uuid;
    }
}
