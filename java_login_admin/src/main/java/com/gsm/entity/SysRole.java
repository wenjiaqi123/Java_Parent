package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统角色表(SysRole)实体类
 *
 * @author makejava
 * @since 2020-03-23 11:16:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysRole{
    
    private Long roleId;
    
    private String roleName;
    /**
    * 0失效  1在用
    */
    private Integer status;

}