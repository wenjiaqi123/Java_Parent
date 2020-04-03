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
public class CheckMQConfig {
    //交换机名称
    @Value("${check.mq.fanout.name}")
    private String fanoutName;
    //队列名称
    @Value("${check.mq.queue.name}")
    private String queueName;

    @Bean
    public FanoutExchange checkFanoutExchange(){
        return new FanoutExchange(fanoutName);
    }

    @Bean
    public Queue checkQueue(){
        return new Queue(queueName);
    }

    @Bean
    public Binding checkBinding(FanoutExchange checkFanoutExchange, Queue checkQueue){
        Binding binding = BindingBuilder.bind(checkQueue).to(checkFanoutExchange);
        return binding;
    }
}
