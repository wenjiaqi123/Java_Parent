package com.gsm.service;

import com.gsm.entity.LoginUser;
import com.gsm.entity.Result;

public interface LoginService {
    Result selectUserCanLoginReturnInfo(LoginUser loginUser);

    Result selectWebUserInfo(Long webUserId);

    Result selectUserCanLoginByVerCodeReturnInfo(String iphoneNo);
}
