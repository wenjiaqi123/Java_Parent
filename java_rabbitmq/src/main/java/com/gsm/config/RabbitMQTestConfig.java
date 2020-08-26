package com.gsm.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTestConfig {

    @Bean
    public FanoutExchange testExchange(){
        /**
         * 交换机类型
         * DirectExchange
         * TopicExchange
         * HeadersExchange
         * FanoutExchange
         */
        FanoutExchange fanoutExchange = new FanoutExchange("testExchange");
        return fanoutExchange;
    }

    @Bean
    public Queue test(){
        /**
         * String name                      队列名称
         * boolean durable                  默认true,是否持久化消息队列 ,rabbitmq重启的时候不需要创建新的队列
         * boolean exclusive                默认false,表示该消息队列是否只在当前connection生效
         * boolean autoDelete               默认false,表示消息队列没有在使用时是否被自动删除，false表示没有在使用时不删除
         * Map<String, Object> arguments
         */
        Queue queue = new Queue("test");
        return queue;
    }

    @Bean
    public Queue test1(){
        Queue queue = new Queue("test1");
        return queue;
    }

    @Bean
    public Binding binding0(FanoutExchange testExchange, Queue test){
        Binding binding = BindingBuilder.bind(test).to(testExchange);
        return binding;
    }

    @Bean
    public Binding binding1(FanoutExchange testExchange, Queue test1){
        Binding binding = BindingBuilder.bind(test1).to(testExchange);
        return binding;
    }
}
