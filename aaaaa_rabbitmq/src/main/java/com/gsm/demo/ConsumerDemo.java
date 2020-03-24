package com.gsm.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
// 填写队列名称
@RabbitListener(queues = "fanoutQueueZero")
public class ConsumerDemo {

    //参数可以是对象，字符串等
    @RabbitHandler
    public void fanoutQueueZero(String s){
        System.out.println("我是消费者 \t 开始消费");
        System.out.println(s);
    }
}
