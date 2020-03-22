package com.gsm.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2020-03-22 00:35:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUser{
    /**
    * id，唯一标识，不到千万，
    */
    private Integer id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 用户昵称
    */
    private String userNickName;
    /**
    * 密码明文
    */
    private String userPwdPlaintext;
    /**
    * 密码密文
    */
    private String userPwdCiphertext;
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
    
    private String createUser;
    
    private Date updateDate;
    
    private String updateUser;
    /**
    * 该记录是否有效
0无效 1有效
    */
    private Integer status;

}