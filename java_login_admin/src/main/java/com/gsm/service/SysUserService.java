package com.gsm.service;

import com.gsm.entity.LoginUser;
import com.gsm.entity.Result;
import com.gsm.entity.SysUser;

/**
 * 后台管理人员账户(SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-03-22 15:09:17
 */
public interface SysUserService {
    LoginUser selectSysUserByAccountAndPwd(SysUser sysUser);

    Result selectSysUser();

    Result insertSysUser(SysUser sysUser);

    Result updateSysUser(SysUser sysUser);

    Result deleteSysUserById(Long userId);

    Result updateSysUserRole(Long userId, Long roleId);
}