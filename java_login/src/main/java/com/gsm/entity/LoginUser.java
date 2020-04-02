package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUser {
    private String account;
    /**
     * 密码明文
     */
    private String userPwdOpen;
    /**
     * 密码密文
     */
    private String userPwdClose;
}
