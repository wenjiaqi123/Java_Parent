package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.entity.SysRole;
import com.gsm.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统角色表(SysRole)表控制层
 *
 * @author makejava
 * @since 2020-04-21 11:00:20
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询数据
     */
    @GetMapping("/roleList")
    public Result selectRoleList() {
        Result result = sysRoleService.selectRoleList();
        return result;
    }

    /**
     * 查询菜单
     */
    @GetMapping("/menus/{roleId}")
    public Result selectMenus(@PathVariable("roleId")Long roleId) {
        Result result = sysRoleService.selectMenus(roleId);
        return result;
    }

    /**
     * 分配角色查询菜单列表
     */
    @GetMapping("/menuRole/{userId}")
    public Result selectUserRole(@PathVariable("userId")Long userId) {
        Result result = sysRoleService.selectUserRole(userId);
        return result;
    }

    /**
     * 新增数据
     */
    @PostMapping("/role")
    public Result insertRole(@RequestBody SysRole sysRole) {
        Result result = sysRoleService.insertRole(sysRole);
        return result;
    }

    /**
     * 修改数据
     */
    @PutMapping("/role/{roleId}")
    public Result updateRole(@PathVariable("roleId") Long roleId, @RequestBody SysRole sysRole) {
        sysRole.setRoleId(roleId);
        Result result = sysRoleService.updateRole(sysRole);
        return result;
    }

    /**
     * 修改菜单
     */
    @PutMapping("/role/menus/{roleId}")
    public Result updateMenusByRoleId(@PathVariable("roleId") Long roleId, @RequestBody Long[] menusIds) {
        Result result = sysRoleService.updateMenusByRoleId(roleId,menusIds);
        return result;
    }

    /**
     * 删除数据
     */
    @DeleteMapping("/role/{roleId}")
    public Result deleteRoleById(@PathVariable("roleId") Long roleId) {
        Result result = sysRoleService.deleteRoleById(roleId);
        return result;
    }

}