package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.service.SmsSendService;
import com.gsm.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sms-send")
public class SmsSendController {
    @Autowired
    private SmsSendService smsSendService;

    /**
     * 发送手机验证码
     *
     * @param iphoneNo
     */
    @GetMapping("/{iphoneNo}")
    public Result sendVerCode(@PathVariable("iphoneNo") String iphoneNo) {
        Result result = smsSendService.sendVerCode(iphoneNo);
        return result;
    }
}
