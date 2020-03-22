package com.gsm.controller;

import com.gsm.entity.LoginUser;
import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
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
@RequestMapping("sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     */
    @PostMapping("selectSysUser")
    public Result selectSysUser(SysUser sysUser) {
        LoginUser loginUser = sysUserService.selectSysUserByAccountAndPwd(sysUser);
        if (loginUser.getSysUser() == null && loginUser.getToken() == null) {
            Result result = new Result(false, StatusCode.ERROR_LOGIN);
            return result;
        }
        Result result = Result.builder()
                .flag(true)
                .code(StatusCode.OK)
                .data(loginUser)
                .build();
        return result;
    }

    /**
     * 通过主键查询单条数据
     */
    @PostMapping("aa")
    public Result aa(@RequestBody SysUser sysUser) {
        LoginUser loginUser = sysUserService.selectSysUserByAccountAndPwd(sysUser);
        if (loginUser.getSysUser() == null && loginUser.getToken() == null) {
            Result result = new Result(false, StatusCode.ERROR_LOGIN);
            return result;
        }
        Result result = Result.builder()
                .flag(true)
                .code(StatusCode.OK)
                .data(loginUser)
                .build();
        return result;
    }

}