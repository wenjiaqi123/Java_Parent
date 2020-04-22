package com.gsm.dao;


import com.gsm.entity.SysMenuRole;

import java.util.List;

/**
 * 菜单角色表(SysMenuRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-21 16:03:44
 */
public interface SysMenuRoleDao {

    int deleteMenuByRoleId(Long roleId);

    int insertMenuRole(List<SysMenuRole> list);
}