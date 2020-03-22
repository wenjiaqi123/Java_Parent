package com.gsm.controller;

import com.gsm.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sms")
public class SmsController {
    @Autowired
    private SmsService smsService;

    /**
     * 发送手机验证码
     * @param iphoneNo
     */
    @GetMapping("verCode/{iphoneNo}")
    public String sendVerCode(@PathVariable("iphoneNo") String iphoneNo) {
        String str = smsService.sendVerCode(iphoneNo);
        return str;
    }
}
