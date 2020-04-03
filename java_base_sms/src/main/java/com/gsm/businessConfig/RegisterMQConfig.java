package com.gsm.businessConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 绑定交换机和消息队列
 */
@Configuration
public class RegisterMQConfig {
    //交换机名称
    @Value("${reg.mq.fanout.name}")
    private String fanoutName;
    //队列名称
    @Value("${reg.mq.queue.name}")
    private String queueName;

    @Bean
    public FanoutExchange regFanoutExchange(){
        return new FanoutExchange(fanoutName);
    }

    @Bean
    public Queue regQueue(){
        return new Queue(queueName);
    }

    @Bean
    public Binding regBinding(FanoutExchange regFanoutExchange, Queue regQueue){
        Binding binding = BindingBuilder.bind(regQueue).to(regFanoutExchange);
        return binding;
    }
}
