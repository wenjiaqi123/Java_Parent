package com.gsm.dao;

import com.gsm.entity.WebUser;

/**
 * 用户表(WebUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-27 13:58:06
 */
public interface RegisterDao {

    int selectIphoneNoIsRegister(Long iphoneNo);

    int insertWebUser(WebUser webUser);
}