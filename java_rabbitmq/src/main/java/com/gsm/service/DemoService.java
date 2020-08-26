package com.gsm.service;

import com.gsm.entity.User;

public interface DemoService {
    String sendMsg(String msg);

    String sendUser(User user);
}
