package com.gsm.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (SysToken)实体类
 *
 * @author makejava
 * @since 2020-03-22 17:35:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysToken{
    
    private Long tokenId;
    /**
    * 用户登录认证 token
    */
    private String token;
    /**
    * 关联的用户id
    */
    private Long userId;
    /**
    * 登录时间
    */
    private Date loginTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 有效天数
    */
    private Integer effectiveTime;
    /**
    * 该记录是否有效
0无效 1有效
    */
    private Integer status;

}