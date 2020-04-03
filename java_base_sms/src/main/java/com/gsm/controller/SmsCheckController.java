package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.service.SmsCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sms-check")
public class SmsCheckController {
    @Autowired
    private SmsCheckService smsCheckService;

    /**
     * 发送手机验证码 ，注册
     * @param iphoneNo
     */
    @GetMapping("/{iphoneNo}")
    public Result sendVerCode(@PathVariable("iphoneNo") String iphoneNo) {
        Result result = smsCheckService.sendVerCode(iphoneNo);
        return result;
    }

    /**
     * 校验手机验证码是否过期，注册
     * @param iphoneNo
     */
    @GetMapping("/{iphoneNo}/{verCode}")
    public Result checkVerCodeIsExpire(@PathVariable("iphoneNo") String iphoneNo, @PathVariable("verCode") String verCode) {
        Result result = smsCheckService.checkVerCodeIsExpire(iphoneNo,verCode);
        return result;
    }
}
