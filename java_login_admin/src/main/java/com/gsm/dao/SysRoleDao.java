package com.gsm.dao;

import com.gsm.entity.RoleMenu;
import com.gsm.entity.SysRole;
import java.util.List;

/**
 * 系统角色表(SysRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-21 11:00:20
 */
public interface SysRoleDao {

    SysRole selectRoleByUserId(Long userId);

    List<SysRole> selectRoleList();

    int insertRole(SysRole sysRole);

    int updateRole(SysRole sysRole);

    int deleteRoleById(Long roleId);

    List<RoleMenu> selectMenus(Long roleId);
}