package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 后台管理人员账户(SysUser)实体类
 *
 * @author makejava
 * @since 2020-03-22 15:09:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUser{
    
    private Long userId;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 手机号
    */
    private String iphoneNo;
    /**
    * 密码明文
    */
    private String userPwdOpen;
    /**
    * 密码密文
    */
    private String userPwdClose;

    private Integer showOrder;
    /**
    * 0失效  1在用
    */
    private Integer status;

    private SysRole sysRole;
}