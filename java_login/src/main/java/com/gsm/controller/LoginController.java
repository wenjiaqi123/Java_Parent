package com.gsm.controller;

import com.gsm.client.SmsCheckCode;
import com.gsm.entity.LoginUser;
import com.gsm.entity.Result;
import com.gsm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表(WebUser)表控制层
 *
 * @author makejava
 * @since 2020-03-27 13:58:06
 */
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private SmsCheckCode smsCheckCode;

    /**
     * 校验用户账户密码是否正确匹配
     * 能够登录，并返回信息 token 和 userInfo
     */
    @PostMapping("/loginUser")
    public Result selectUserCanLoginReturnInfo(@RequestBody LoginUser loginUser) {
        Result result = loginService.selectUserCanLoginReturnInfo(loginUser);
        return result;
    }

    /**
     * 根据用户id获取信息
     */
    @GetMapping("/{webUserId}")
    public Result selectWebUserInfo(@PathVariable("webUserId")Long webUserId) {
        Result result = loginService.selectWebUserInfo(webUserId);
        return result;
    }

    /**
     * 根据 手机号 和 验证码 校验是否能够登录，返回用户信息
     * 能够登录，并返回信息 token 和 userInfo
     */
    @GetMapping("/{iphoneNo}/{verCode}")
    public Result selectUserCanLoginByVerCodeReturnInfo(@PathVariable("iphoneNo") String iphoneNo, @PathVariable("verCode") String verCode) {
        Result r = smsCheckCode.checkVerCodeIsExpire(iphoneNo, verCode);
        if(r.getFlag()){
            Result result = loginService.selectUserCanLoginByVerCodeReturnInfo(iphoneNo);
            return result;
        }else {
            return r;
        }
    }
}