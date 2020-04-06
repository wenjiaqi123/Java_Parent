package com.gsm.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigQueue {
   /* @Value("${fanoutExchange.name}")
    private String fanoutName;

    @Bean
    public Queue queueFastDFSQueue(){
        return new Queue("fastDFSQueue");
    }

    @Bean
    public Queue queueStoreQueue(){
        return new Queue("storeQueue");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        FanoutExchange fanoutExchange = new FanoutExchange(fanoutName);
        return fanoutExchange;
    }

    @Bean
    public Binding binding0(FanoutExchange fanoutExchange, Queue queueFastDFSQueue){
        Binding binding = BindingBuilder.bind(queueFastDFSQueue).to(fanoutExchange);
        return binding;
    }

    @Bean
    public Binding binding1(FanoutExchange fanoutExchange, Queue queueStoreQueue){
        Binding binding = BindingBuilder.bind(queueStoreQueue).to(fanoutExchange);
        return binding;
    }*/
}
