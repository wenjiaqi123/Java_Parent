package com.gsm.service.impl;

import com.gsm.JavaRabbitMQApplication;
import com.gsm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavaRabbitMQApplication.class)
public class DemoServiceImplTest {
    @Autowired
    private DemoServiceImpl demoService;

    @Test
    public void sendMsg() {
        String s = demoService.sendMsg("我是msg");
        System.out.println(s);
    }

    @Test
    public void sendUser() {
        User user = User.builder()
                .name("闻家奇")
                .age(18)
                .build();
        String s = demoService.sendUser(user);
        System.out.println(s);
    }
}