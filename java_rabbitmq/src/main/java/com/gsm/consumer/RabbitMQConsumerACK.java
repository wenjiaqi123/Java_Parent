package com.gsm.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitMQConsumerACK {

    @RabbitListener(queues = "test")
    public void process(Message message, Channel channel) throws IOException {
        System.out.println("test:-----body\t" + new String(message.getBody()));
        // 采用手动应答模式, 手动确认应答更为安全稳定
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }

    @RabbitListener(queues = "test1")
    public void process1(Message message, Channel channel) throws IOException {
        System.out.println("test1:-----body\t" + new String(message.getBody()));
        // 采用手动应答模式, 手动确认应答更为安全稳定
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }
}