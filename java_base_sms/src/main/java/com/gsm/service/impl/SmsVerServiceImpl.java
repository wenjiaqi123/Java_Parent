package com.gsm.service.impl;

import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.service.SmsVerService;
import com.gsm.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsVerServiceImpl implements SmsVerService {
    @Autowired
    private RedisUtils redisUtils;

    //校验验证码和手机号是否匹配
    @Override
    public Result checkVerCodeIsExpire(String iphoneNo, String verCode) {
        String key = "sms_" + iphoneNo + "_" + verCode;
        boolean b = redisUtils.hasKey(key);
        if(b){
            Result result = new Result(true, StatusCode.OK,"","手机号与验证码一致");
            return result;
        }else {
            Result result = new Result(false, StatusCode.ERROR_ACCESS,"","手机号与验证码不一致");
            return result;
        }
    }
}
