package com.gsm.dao;

import com.gsm.entity.SysMenu;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 系统菜单(SysMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-22 23:28:16
 */
public interface SysMenuDao {
    List<SysMenu> selectMenuListByUserId(Long userId);
}