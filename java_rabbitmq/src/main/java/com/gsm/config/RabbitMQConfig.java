package com.gsm.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("all")
public class RabbitMQConfig {
    @Autowired
    private RabbitTemplate rabbitTemplate;

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

    /**
     * 传输序列化对象
     * @return
     */

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        //序列化对象
        Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        return rabbitTemplate;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        //消息发送失败返回队列机制,yml 中配置 publisher-returns: true
        rabbitTemplate.setMandatory(true);
        //消息发送确认机制,yml 中配置 publisher-confirms: true
        rabbitTemplate.setConfirmCallback((correlationData,ack,cause)->{
            if (ack){
                System.out.println("发送成功");
            }else {
                System.out.println("发送失败");
            }
        });
        //消息返回确认机制,yml 中配置 publisher-returns: true
        rabbitTemplate.setReturnCallback((msg,replyCode,replyText,exchange,routingKey)->{
            System.out.println("消息主体: " + SerializationUtils.deserialize(msg.getBody()));
            System.out.println("应答码: " + replyCode);
            System.out.println("描述：" + replyText);
            System.out.println("消息使用的交换器 exchange : " + exchange);
            System.out.println("消息使用的路由键 routing : " + routingKey);
        });
        return null;
    }
}
