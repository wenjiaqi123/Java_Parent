package com.gsm.dao;

import com.gsm.entity.WebUser;

public interface LoginDao {
    WebUser selectUserPwdByAccount(String account);

    WebUser selectUserInfoByUserId(Long webUserId);
}
