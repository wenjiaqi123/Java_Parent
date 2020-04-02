package com.gsm.service;

import com.gsm.entity.Result;

public interface SmsSendService {
    Result sendVerCode(String iphoneNo);
}
