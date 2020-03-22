package com.gsm.service.impl;

import com.gsm.consumer.SmsConsumer;
import com.gsm.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {
    @Autowired
    private SmsConsumer smsConsumer;

    @Override
    public String sendVerCode(String iphoneNo) {
        try {
            smsConsumer.consumerSendSmsByIphoneNo(iphoneNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "发送成功";
    }
}
