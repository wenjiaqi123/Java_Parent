package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 系统菜单(SysMenu)实体类
 *
 * @author makejava
 * @since 2020-03-22 23:28:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysMenu{
    /**
    * 主键Id
    */
    private Long menuId;
    /**
    * 菜单名称
    */
    private String menuName;
    /**
    * 菜单 code
    */
    private String menuCode;
    /**
    * 菜单的父id
    */
    private Long menuPid;
    /**
    * 显示顺序
    */
    private Integer showOrder;

    private List<SysMenu> sysMenuList;
}