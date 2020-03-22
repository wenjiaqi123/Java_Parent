package com.gsm.controller;

import com.gsm.entity.SysUser;
import com.gsm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-03-22 00:35:46
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysUser selectOne(Integer id) {
        return sysUserService.queryById(id);
    }

}