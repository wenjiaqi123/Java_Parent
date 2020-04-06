package com.gsm.config;

import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    /**
     * 传输序列化对象
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
        ContentTypeDelegatingMessageConverter converter = new ContentTypeDelegatingMessageConverter(jsonMessageConverter);
        return converter;
    }
}
