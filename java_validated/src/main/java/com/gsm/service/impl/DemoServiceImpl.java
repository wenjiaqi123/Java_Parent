package com.gsm.service.impl;

import com.gsm.entity.Car;
import com.gsm.entity.User;
import com.gsm.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    /**
     * @param user
     * @return
     */
    @Override
    public String insertDemo(User user) {
        return "s";
    }

    /**
     * @param nickName
     * @return
     */
    @Override
    public String selectDemo(String nickName) {
        return "s";
    }

    @Override
    public String updateDemo(User user) {
        return "s";
    }
}
