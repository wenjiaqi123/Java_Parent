package com.gsm.consumer;

import com.gsm.entity.SmsCode;
import com.gsm.utils.RandomNumUtils;
import com.gsm.utils.RedisUtils;
import com.gsm.utils.SmsCodeUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
// 填写队列名称
@RabbitListener(queues = "smsQueue")
public class SmsConsumer {
    @Autowired
    private SmsCodeUtils smsCodeUtils;
    @Autowired
    private RedisUtils redisUtils;

    //过期时间
    @Value("${sms.expireTime}")
    private Integer expireTime;

    @RabbitHandler
    public void sendIphoneNo(String iphoneNo){
        System.out.println("准备向手机号\t" + iphoneNo + "\t发送短信");

        //生成四位验证码
        Integer random4 = RandomNumUtils.getRandom4();
        //发送短信
        boolean b = smsCodeUtils.sendSmsCodeOneIphoneNo(new SmsCode(iphoneNo, random4));
        if(b){
            //存入redis
            String key = "sms_" + iphoneNo + "_" + random4;
            redisUtils.set(key,random4,expireTime);
        }
    }
}
