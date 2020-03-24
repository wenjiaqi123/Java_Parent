package com.gsm.service.impl;

import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.entity.SysMenu;
import com.gsm.dao.SysMenuDao;
import com.gsm.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 系统菜单(SysMenu)表服务实现类
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public Result selectMenuListByUserId(Long userId) {
        List<SysMenu> list = sysMenuDao.selectMenuListByUserId(userId);
        List<SysMenu> menuList = new ArrayList<>();
        List<SysMenu> sonList = new ArrayList<>();
        Iterator<SysMenu> iterator = list.iterator();
        while (iterator.hasNext()) {
            SysMenu next = iterator.next();
            if (next.getMenuPid() == 0) {
                menuList.add(next);
                iterator.remove();
            } else {
                sonList.add(next);
            }
        }

        menuList.forEach(i -> {
            Iterator<SysMenu> iterator1 = sonList.iterator();
            List<SysMenu> temList = new ArrayList<>();
            while (iterator1.hasNext()) {
                SysMenu next = iterator1.next();
                if (next.getMenuPid() == i.getMenuId()) {
                    temList.add(next);
                    iterator1.remove();
                }
            }
            i.setSysMenuList(temList);
        });

        Result result = new Result(true, StatusCode.OK, "", menuList);
        return result;
    }
}