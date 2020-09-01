package com.gsm.controller;

import com.gsm.JavaLogApplication;
import com.gsm.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("log")
public class DemoController {
    @Autowired
    private DemoService demoService;
    private static Logger log = LoggerFactory.getLogger(JavaLogApplication.class);

    @GetMapping("demo")
    public String selectSomething(String name){
        String s = demoService.selectSomething(name);
        log.info(name);
        return s;
    }
}
