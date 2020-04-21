package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色表(SysUserRole)实体类
 *
 * @author makejava
 * @since 2020-04-21 23:40:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUserRole{
    
    private Long userRoleId;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 角色id
    */
    private Long roleId;

}