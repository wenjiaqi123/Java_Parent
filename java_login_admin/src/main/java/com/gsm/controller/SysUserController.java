package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.entity.SysUser;
import com.gsm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 后台管理人员账户(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-03-22 15:09:17
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询管理员列表
     */
    @GetMapping("/selectSysUser")
    public Result selectSysUser() {
        Result result = sysUserService.selectSysUser();
        return result;
    }

    /**
     * 添加账号
     */
    @PostMapping("/user")
    public Result insertSysUser(@RequestBody SysUser sysUser) {
        Result result = sysUserService.insertSysUser(sysUser);
        return result;
    }

    /**
     * 修改账号信息
     */
    @PutMapping("/user/{userId}")
    public Result updateSysUser(@PathVariable("userId")Long userId,@RequestBody SysUser sysUser) {
        sysUser.setUserId(userId);
        Result result = sysUserService.updateSysUser(sysUser);
        return result;
    }

    /**
     * 修改账号角色信息
     */
    @PutMapping("/userRole/{userId}/{roleId}")
    public Result updateSysUserRole(@PathVariable("userId")Long userId,@PathVariable("roleId")Long roleId) {
        Result result = sysUserService.updateSysUserRole(userId,roleId);
        return result;
    }

    /**
     * 删除账号
     */
    @DeleteMapping("/user/{userId}")
    public Result deleteSysUserById(@PathVariable("userId")Long userId) {
        Result result = sysUserService.deleteSysUserById(userId);
        return result;
    }
}