package com.gsm.service.impl;

import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.service.SmsRegService;
import com.gsm.utils.RedisUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsRegServiceImpl implements SmsRegService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisUtils redisUtils;

    //交换机名称
    @Value("${reg.mq.fanout.name}")
    private String fanoutName;
    //队列名称
    @Value("${reg.mq.queue.name}")
    private String queueName;

    @Override
    public Result sendVerCode(String iphoneNo) {
        //调用消息队列发送消息
        System.out.println("-----发送手机号给消息队列-----");
        rabbitTemplate.convertAndSend(fanoutName,queueName,iphoneNo);
        System.out.println("-----发送手机号给消息队列结束-----");
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    //校验验证码和手机号是否匹配
    @Override
    public Result checkVerCodeIsExpire(String iphoneNo, String verCode) {
        String key = "sms_" + iphoneNo + "_" + verCode;
        boolean b = redisUtils.hasKey(key);
        if(b){
            Result result = new Result(true, StatusCode.OK,"","手机号与验证码一致");
            return result;
        }else {
            Result result = new Result(false, StatusCode.ERROR_ACCESS,"","手机号与验证码不一致");
            return result;
        }
    }
}
