package com.gsm.service.impl;

import com.gsm.entity.User;
import com.gsm.service.DemoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sendMsg(String msg) {
        /**
         * 发送消息
         */
        rabbitTemplate.convertAndSend("testExchange", "", msg);
        User user = new User(msg, (int) (Math.random() * (10 - 1 + 1)) + 1);
        //int i = 1/0;
        rabbitTemplate.convertAndSend("testExchange", "", user);
        return "success";
    }

    @Override
    public String sendUser(User user) {
        user.setAge((int) (Math.random() * (10 - 1 + 1)) + 1);
        rabbitTemplate.convertAndSend("testExchange", "test", user);
        return "success";
    }
}
