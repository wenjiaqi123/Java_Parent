package com.gsm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * 监听器配置
 */
@Configuration
public class RedisListenerConfig {
    @Autowired
    private RedisMessageListener redisMessageListener;

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.addMessageListener(redisMessageListener,expiredTopic());
        container.addMessageListener(redisMessageListener,girl());
        container.setConnectionFactory(connectionFactory);
        //下面这种方式是灵活配置，针对每个库的失效key做处理
        //container.addMessageListener(new RedisExpiredListener(), new PatternTopic("__keyevent@0__:expired"));
        return container;
    }

    @Bean
    public ChannelTopic expiredTopic() {
        return new ChannelTopic("__keyevent@0__:expired");
    }

    @Bean
    public ChannelTopic girl() {
        return new ChannelTopic("girl");
    }

}
