package com.gsm.controller;

import com.gsm.entity.User;
import com.gsm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mq")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @PostMapping("/send")
    public String sendMsg(String msg){
        String s = demoService.sendMsg(msg);
        return "success";
    }

    @PostMapping("/user")
    public String sendUser(@RequestBody User user){
        String s = demoService.sendUser(user);
        return "success";
    }
}