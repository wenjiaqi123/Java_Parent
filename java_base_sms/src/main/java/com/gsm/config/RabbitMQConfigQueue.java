package com.gsm.config;

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
public class RabbitMQConfigQueue {
    @Value("${fanoutExchange.name}")
    private String fanoutName;

    @Value("${queue.name}")
    private String queueName;

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(fanoutName);
    }

    @Bean
    public Queue queue(){
        return new Queue(queueName);
    }


    @Bean
    public Binding binding(FanoutExchange fanoutExchange, Queue queue){
        Binding binding = BindingBuilder.bind(queue).to(fanoutExchange);
        return binding;
    }
}
