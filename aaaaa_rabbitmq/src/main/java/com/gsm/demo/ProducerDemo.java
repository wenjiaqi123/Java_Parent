package com.gsm.demo;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ProducerDemo {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private FanoutExchange fanoutExchange;

    public void insertRabbitmqDemoFanout() {
        System.out.println("-----fanout 发送准备-----");
        String exchange = fanoutExchange.getName();
        fanoutExchange.getName();
        rabbitTemplate.convertAndSend(exchange,"队列名称","这里是传输的对象");
        System.out.println("-----fanout 发送结束-----");
    }
}
