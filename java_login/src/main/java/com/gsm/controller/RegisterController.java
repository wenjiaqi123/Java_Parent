package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.entity.WebUser;
import com.gsm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表(WebUser)表控制层
 *
 * @author makejava
 * @since 2020-03-27 13:58:06
 */
@RestController
@RequestMapping("reg")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    //查询手机号是否已经注册
    @GetMapping("/{iphoneNo}")
    public Result selectIphoneNoIsRegister(@PathVariable("iphoneNo")Long iphoneNo) {
        Result result = registerService.selectIphoneNoIsRegister(iphoneNo);
        return result;
    }

    //用户信息注册
    @PostMapping("/webUser")
    public Result insertWebUser(@RequestBody WebUser webUser) {
        Result result = registerService.insertWebUser(webUser);
        return result;
    }
}