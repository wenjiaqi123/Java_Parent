package com.gsm.service;

import com.gsm.entity.Result;

public interface SmsVerService {
    Result checkVerCodeIsExpire(String iphoneNo, String verCode);
}
