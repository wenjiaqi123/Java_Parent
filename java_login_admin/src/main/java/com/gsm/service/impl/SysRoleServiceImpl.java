package com.gsm.service.impl;

import com.gsm.dao.SysMenuDao;
import com.gsm.dao.SysMenuRoleDao;
import com.gsm.entity.*;
import com.gsm.dao.SysRoleDao;
import com.gsm.service.SysRoleService;
import com.gsm.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 系统角色表(SysRole)表服务实现类
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysMenuRoleDao sysMenuRoleDao;
    @Autowired
    private IdUtils idUtils;

    @Override
    public Result selectRoleList() {
        List<SysRole> list = sysRoleDao.selectRoleList();
        Result result = new Result(true, StatusCode.OK, "", list);
        return result;
    }

    @Override
    public Result selectMenus(Long roleId) {
        List<RoleMenu> list = sysRoleDao.selectMenus(roleId);
        List<RoleMenu> pidList = new ArrayList<>();
        List<RoleMenu> childList = new ArrayList<>();
        //将list筛选
        list.forEach(i -> {
            if (i.getPid() == 0) {
                pidList.add(i);
            } else {
                childList.add(i);
            }
        });

        //筛选插入
        pidList.forEach(i -> {
            List<RoleMenu> tmpList = new ArrayList<>();
            Iterator<RoleMenu> iterator = childList.iterator();
            while (iterator.hasNext()) {
                RoleMenu next = iterator.next();
                if (next.getPid() == i.getMenuId()) {
                    tmpList.add(next);
                    iterator.remove();
                }
            }
            i.setChildren(tmpList);
        });
        Result result = new Result(true, StatusCode.OK, "", pidList);
        return result;
    }

    @Override
    public Result updateMenusByRoleId(Long roleId, Long[] menusIds) {
        //根据角色id删除菜单
        sysMenuRoleDao.deleteMenuByRoleId(roleId);
        if (menusIds.length != 0) {
            //数据组装
            List<SysMenuRole> list = new ArrayList<>();
            for (int i = 0; i < menusIds.length; i++) {
                SysMenuRole sysMenuRole = SysMenuRole.builder()
                        .menuRoleId(idUtils.nextId())
                        .roleId(roleId)
                        .menuId(menusIds[i])
                        .build();
                list.add(sysMenuRole);
            }
            //新增菜单角色
            sysMenuRoleDao.insertMenuRole(list);
        }
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result selectUserRole(Long userId) {
        List<RoleUser> list = sysRoleDao.selectUserRole(userId);
        Result result = new Result(true, StatusCode.OK,"",list);
        return result;
    }

    @Override
    public Result insertRole(SysRole sysRole) {
        long roleId = idUtils.nextId();
        sysRole.setRoleId(roleId);
        sysRole.setStatus(1);
        sysRoleDao.insertRole(sysRole);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result updateRole(SysRole sysRole) {
        sysRoleDao.updateRole(sysRole);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result deleteRoleById(Long roleId) {
        sysRoleDao.deleteRoleById(roleId);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }
}