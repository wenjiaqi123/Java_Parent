package com.gsm.service;

import com.gsm.entity.User;

public interface DemoService {
    String insertDemo(User user);

    String selectDemo(String nickName);

    String updateDemo(User user);
}
