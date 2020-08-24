package com.gsm.controller;

import com.gsm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemoController { 
    @Autowired
    private DemoService demoService;
}