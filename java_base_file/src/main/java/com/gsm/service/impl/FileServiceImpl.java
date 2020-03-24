package com.gsm.service.impl;

import com.gsm.service.FileService;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private FanoutExchange fanoutExchange;

    @Override
    public String insertFile(MultipartFile file) {
        System.out.println("-----文件 发送消息队列开始-----");
        String exchange = fanoutExchange.getName();
        String filename = file.getOriginalFilename();
        rabbitTemplate.convertAndSend(exchange,"",filename);
        System.out.println("-----文件 发送消息队列结束-----");
        return "";
    }
}
