package com.gsm.dao;


import com.gsm.entity.SysToken;

/**
 * (SysToken)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-22 17:35:57
 */
public interface SysTokenDao {

    String selectTokenByUserId(Long userId);
}