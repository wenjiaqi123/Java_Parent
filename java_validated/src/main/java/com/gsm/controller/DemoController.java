package com.gsm.controller;

import com.gsm.entity.User;
import com.gsm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    /**
     * 分组校验，指定分组校验组
     * @param user
     * @return
     */
    @PostMapping("insert")
    public String insertDemo(@Validated(value = User.insert.class) @RequestBody User user){
        String s = demoService.insertDemo(user);
        return "success";
    }

    @PutMapping("update")
    public String updateDemo(@Validated(value = User.update.class) @RequestBody User user){
        String s = demoService.updateDemo(user);
        return "success";
    }

    @GetMapping("select")
    public String selectDemo(String nickName){
        String s = demoService.selectDemo(nickName);
        return "success";
    }
}