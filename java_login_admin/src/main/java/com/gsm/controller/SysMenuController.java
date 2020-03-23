package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.entity.SysMenu;
import com.gsm.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统菜单(SysMenu)表控制层
 *
 * @author makejava
 * @since 2020-03-22 23:28:16
 */
@RestController
@RequestMapping("sysMenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("menus/{userId}")
    public Result selectMenuList(@PathVariable("userId") Long userId) {
        Result result = sysMenuService.selectMenuListByUserId(userId);
        return result;
    }

}