package com.gsm.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 配置的就是 redis的消息监听器
 *  获取 redis 消息并处理
 */
@Component
public class RedisMessageListener implements MessageListener {

    /**
     *
     * @param message 完整的消息（频道的信息，消息的内容）
     * @param bytes
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] channel = message.getChannel();
        byte[] body = message.getBody();

        System.out.println("message = " + message.toString());
        System.out.println("body = " + new String(body));
    }
}