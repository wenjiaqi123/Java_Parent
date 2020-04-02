package com.gsm.service.impl;

import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.service.SmsSendService;
import com.gsm.utils.RandomNumUtils;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsSendServiceImpl implements SmsSendService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private FanoutExchange fanoutExchange;

    @Override
    public Result sendVerCode(String iphoneNo) {
        //调用消息队列发送消息
        System.out.println("-----发送手机号给消息队列-----");
        String exchange = fanoutExchange.getName();
        rabbitTemplate.convertAndSend(exchange,"",iphoneNo);
        System.out.println("-----发送手机号给消息队列结束-----");
        Result result = new Result(true, StatusCode.OK);
        return result;
    }
}
