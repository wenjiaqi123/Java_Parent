package com.gsm.consumer;

import com.gsm.entity.User;
import org.springframework.stereotype.Component;

/**
 * @RabbitListener(queues = "test") 监听名为 test 的队列
 */
@Component
//@RabbitListener(queues = "test1")
public class RabbitMQConsumer2 {

    //@RabbitHandler
    public void consumerMsg(String s){
        System.out.println("test1 队列的String\t" + s);
    }

    //@RabbitHandler
    public void consumerUser(User user){
        System.out.println("test1 队列的姓名" + user.getName() + "\t年龄" + user.getAge());
    }
}