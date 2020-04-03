package com.gsm.dao;

import com.gsm.entity.WebUser;

public interface LoginDao {
    WebUser selectUserPwdByAccount(String account);

    WebUser selectUserPwdByIphoneNo(String iphoneNo);

    WebUser selectUserInfoByUserId(Long webUserId);
}
