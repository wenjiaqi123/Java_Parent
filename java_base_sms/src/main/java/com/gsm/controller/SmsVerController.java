package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.service.SmsVerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sms-ver")
public class SmsVerController {
    @Autowired
    private SmsVerService smsVerService;

    /**
     * 校验手机验证码是否过期
     *
     * @param iphoneNo
     */
    @GetMapping("/{iphoneNo}/{verCode}")
    public Result checkVerCodeIsExpire(@PathVariable("iphoneNo") String iphoneNo, @PathVariable("verCode") String verCode) {
        Result result = smsVerService.checkVerCodeIsExpire(iphoneNo,verCode);
        return result;
    }
}
