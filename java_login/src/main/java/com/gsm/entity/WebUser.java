package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户表(WebUser)实体类
 *
 * @author makejava
 * @since 2020-03-27 13:58:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebUser{
    /**
    * id，唯一标识，不到千万，
    */
    private Long webUserId;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 密码明文
    */
    private String userPwdOpen;
    /**
    * 密码密文
    */
    private String userPwdClose;
    /**
    * 身份证
    */
    private String identityCard;
    /**
    * 手机号
    */
    private String iphoneNo;
    /**
    * 邮箱
    */
    private String userEmail;
    /**
    * 头像
    */
    private String headPortrait;
    
    private Date createDate;
    
    private Date updateDate;
    /**
    * 该记录是否有效 0无效 1有效
    */
    private Integer status;

}