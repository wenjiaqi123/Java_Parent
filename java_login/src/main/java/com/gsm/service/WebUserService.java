package com.gsm.service;

import com.gsm.entity.Result;
import com.gsm.entity.WebUser;

/**
 * 用户表(WebUser)表服务接口
 *
 * @author makejava
 * @since 2020-04-02 14:10:26
 */
public interface WebUserService {

    Result updateWebUserInfoById(WebUser webUser);

    Result updatePwdByIphoneNo(WebUser webUser);
}