package com.gsm.dao;

import com.gsm.entity.SysRole;

public interface SysRoleDao {
    SysRole selectRoleByUserId(Long userId);
}