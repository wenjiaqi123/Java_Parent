package com.gsm.controller;

import com.gsm.JavaRedisApplication;
import com.gsm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavaRedisApplication.class)
public class DemoControllerTest {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Test
    public void test1(){
        redisTemplate.opsForValue().set("name","aaaaa",100, TimeUnit.SECONDS);
    }

    @Test
    public void test2(){
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    @Test
    public void test3(){
        User user = User.builder()
                .id("12345")
                .name("闻家奇")
                .age(18)
                .build();
        redisTemplate.convertAndSend("girl",user);
    }
}