package com.gsm.service;

import com.gsm.entity.Result;
import com.gsm.entity.SysMenu;
import java.util.List;

/**
 * 系统菜单(SysMenu)表服务接口
 *
 * @author makejava
 * @since 2020-03-22 23:28:16
 */
public interface SysMenuService {
    Result selectMenuListByUserId(Long userId);
}