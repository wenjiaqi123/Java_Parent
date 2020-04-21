package com.gsm.dao;

import com.gsm.entity.SysUserRole;

/**
 * 用户角色表(SysUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-21 23:41:32
 */
public interface SysUserRoleDao {

    int deleteUserRole(Long userId);

    int insertUserRole(SysUserRole sysUserRole);
}