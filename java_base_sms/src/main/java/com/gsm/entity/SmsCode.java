package com.gsm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SmsCode {
    private String iphoneNo;
    private Integer smsCode;
    private String json;

    public SmsCode(String iphoneNo, Integer smsCode) {
        this.iphoneNo = iphoneNo;
        this.smsCode = smsCode;
    }
}
