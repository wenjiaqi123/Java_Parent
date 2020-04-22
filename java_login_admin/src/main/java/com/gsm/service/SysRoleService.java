package com.gsm.service;

import com.gsm.entity.Result;
import com.gsm.entity.SysRole;
import java.util.List;

/**
 * 系统角色表(SysRole)表服务接口
 *
 * @author makejava
 * @since 2020-04-21 11:00:20
 */
public interface SysRoleService {

    Result selectRoleList();

    Result insertRole(SysRole sysRole);

    Result updateRole(SysRole sysRole);

    Result deleteRoleById(Long roleId);

    Result selectMenus(Long roleId);

    Result updateMenusByRoleId(Long roleId, Long[] menusIds);

    Result selectUserRole(Long userId);
}