package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统角色表(SysRole)实体类
 *
 * @author makejava
 * @since 2020-04-21 11:00:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysRole{
    
    private Long roleId;
    
    private String roleName;
    /**
    * 描述
    */
    private String roleDesc;
    /**
    * 0失效  1在用
    */
    private Integer status;

}