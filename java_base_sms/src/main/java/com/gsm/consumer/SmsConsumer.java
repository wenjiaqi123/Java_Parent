package com.gsm.consumer;

import com.gsm.entity.SmsCode;
import com.gsm.utils.RandomNumUtils;
import com.gsm.utils.SmsCodeUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import utils.RedisUtils;

@Component
@RabbitListener(queues = "sms")
public class SmsConsumer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SmsCodeUtils smsCodeUtils;

    //过期时间
    @Value("${sms.expireTime}")
    private Integer expireTime;

    @RabbitHandler
    public void consumerSendSmsByIphoneNo(String iphoneNo) {
        String key = "sms_" + iphoneNo;
        //生成四位验证码
        Integer random4 = RandomNumUtils.getRandom4();
        //从redis中校验该手机号是否已经发送过验证码
        boolean b = redisUtils.hasKey(key);
        //没有发送过，或以过期
        if (!b) {
            System.out.println("手机号\t" + (b ? "存在" : "不存在"));
            //发送短信
            smsCodeUtils.sendSmsCodeOneIphoneNo(new SmsCode(iphoneNo, random4));
            //将手机号和验证码存入redis缓存
            redisUtils.set(key, random4, expireTime);
            System.out.println("-----结束-----");
        } else {
            //过期时间
            long expire = redisUtils.getExpire(key);
            if (expire > 120) {
                Integer o = (Integer) redisUtils.get(key);
                redisUtils.set(key, o, expireTime);
            }else {
                random4 = RandomNumUtils.getRandom4();
                smsCodeUtils.sendSmsCodeOneIphoneNo(new SmsCode(iphoneNo, random4));
                redisUtils.set(key, random4, expireTime);
            }
        }
    }
}
