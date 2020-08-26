package com.gsm.consumer;

import com.gsm.entity.User;
import org.springframework.stereotype.Component;

/**
 * @RabbitListener(queues = "test") 监听名为 test 的队列
 */
@Component
//@RabbitListener(queues = "test")
public class RabbitMQConsumer {

    //@RabbitHandler
    public void consumerMsg(String s){
        System.out.println("test 队列的String\t" + s);
    }

    //@RabbitHandler
    public void consumerUser(User user){
        System.out.println("test 队列的 姓名" + user.getName() + "\t年龄" + user.getAge());
    }
}