package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 菜单角色表(SysMenuRole)实体类
 *
 * @author makejava
 * @since 2020-04-21 16:03:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysMenuRole{
    
    private Long menuRoleId;
    /**
    * 角色id
    */
    private Long roleId;
    /**
    * 菜单id
    */
    private Long menuId;

}