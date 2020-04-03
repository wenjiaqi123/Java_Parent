package com.gsm.client.impl;

import com.gsm.client.SmsCheckCode;
import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import org.springframework.stereotype.Service;

@Service
public class SmsCheckCodeImpl implements SmsCheckCode {

    @Override
    public Result checkVerCodeIsExpire(String iphoneNo, String verCode) {
        Result result = new Result(false, StatusCode.ERROR_ACCESS,"","请重试");
        return result;
    }
}
