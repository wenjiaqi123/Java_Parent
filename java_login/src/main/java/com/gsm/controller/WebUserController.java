package com.gsm.controller;

import com.gsm.client.SmsCheckCode;
import com.gsm.entity.Result;
import com.gsm.entity.WebUser;
import com.gsm.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表(WebUser)表控制层
 *
 * @author makejava
 * @since 2020-04-02 14:10:26
 */
@RestController
@RequestMapping("/webUser")
public class WebUserController {
    @Autowired
    private WebUserService webUserService;
    @Autowired
    private SmsCheckCode smsCheckCode;

    @PutMapping("/user/{webUserId}")
    public Result updateWebUserInfoById(@PathVariable("webUserId") Long webUserId,@RequestBody WebUser webUser){
        webUser.setWebUserId(webUserId);
        Result result = webUserService.updateWebUserInfoById(webUser);
        return result;
    }

    @PutMapping("/{iphoneNo}/{verCode}")
    public Result updatePwdByIphoneNo(@PathVariable("iphoneNo") String iphoneNo, @PathVariable("verCode") String verCode,@RequestBody WebUser webUser){
        Result r = smsCheckCode.checkVerCodeIsExpire(iphoneNo, verCode);
        if(r.getFlag()){
            webUser.setIphoneNo(iphoneNo);
            Result result = webUserService.updatePwdByIphoneNo(webUser);
            return result;
        }else {
            return r;
        }
    }
}