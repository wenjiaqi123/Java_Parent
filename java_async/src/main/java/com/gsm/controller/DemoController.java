package com.gsm.controller;

import com.gsm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("async")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("file")
    public String transferFile(String from, String to) {
        long start = System.currentTimeMillis();
        String s = demoService.transferFile(from, to);
        long end = System.currentTimeMillis();
        System.out.println("共耗时" + (end - start) + "毫秒");
        return s;
    }
}
