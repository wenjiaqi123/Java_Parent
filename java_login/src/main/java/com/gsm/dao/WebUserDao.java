package com.gsm.dao;

import com.gsm.entity.WebUser;

/**
 * 用户表(WebUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-02 14:10:26
 */
public interface WebUserDao {

    int updateWebUserInfoById(WebUser webUser);
}