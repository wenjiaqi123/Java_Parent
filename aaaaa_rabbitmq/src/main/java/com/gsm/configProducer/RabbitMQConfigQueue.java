package com.gsm.configProducer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigQueue {
    @Value("${fanoutexchange.name}")
    private String fanoutName;

    @Bean
    public Queue queue(){
        return new Queue("myQueue");
    }

    @Bean
    public Queue queue0(){
        return new Queue("fanoutQueueZero");
    }

    @Bean
    public Queue queue1(){
        return new Queue("fanoutQueueOne");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        FanoutExchange fanoutExchange = new FanoutExchange(fanoutName);
        return fanoutExchange;
    }

    @Bean
    public Binding binding0(FanoutExchange fanoutExchange, Queue queue0){
        Binding binding = BindingBuilder.bind(queue0).to(fanoutExchange);
        return binding;
    }

    @Bean
    public Binding binding1(FanoutExchange fanoutExchange, Queue queue1){
        Binding binding = BindingBuilder.bind(queue1).to(fanoutExchange);
        return binding;
    }
}
