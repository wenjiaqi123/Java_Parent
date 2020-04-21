package com.gsm.dao;

import com.gsm.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 后台管理人员账户(SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-22 15:09:17
 */
public interface SysUserDao {

    SysUser selectSysUserByAccountAndPwd(SysUser sysUser);

    List<SysUser> selectAllSysUser();

    int insertSysUser(SysUser sysUser);

    int updateSysUser(SysUser sysUser);

    int deleteSysUserById(Long userId);
}