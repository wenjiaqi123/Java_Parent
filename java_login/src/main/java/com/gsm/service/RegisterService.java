package com.gsm.service;

import com.gsm.entity.Result;
import com.gsm.entity.WebUser;

/**
 * 用户表(WebUser)表服务接口
 *
 * @author makejava
 * @since 2020-03-27 13:58:06
 */
public interface RegisterService {

    Result selectIphoneNoIsRegister(Long iphoneNo);

    Result insertWebUser(WebUser webUser);
}