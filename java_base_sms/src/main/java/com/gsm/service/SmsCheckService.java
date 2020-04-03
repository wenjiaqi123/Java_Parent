package com.gsm.service;

import com.gsm.entity.Result;

public interface SmsCheckService {
    Result sendVerCode(String iphoneNo);

    Result checkVerCodeIsExpire(String iphoneNo, String verCode);
}
