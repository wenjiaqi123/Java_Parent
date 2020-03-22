package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 建议反馈表(Suggestion)实体类
 *
 * @author makejava
 * @since 2020-03-22 10:19:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Suggestion{
    
    private Integer id;
    /**
    * 反馈类型  
1功能故障  
2优化建议  
3其他
    */
    private Integer suggestType;
    /**
    * 反馈描述
    */
    private String suggestDesc;
    /**
    * 手机号
    */
    private String iphoneNo;
    /**
    * 邮箱号
    */
    private String email;
    /**
    * 状态 0失效
    */
    private Integer status;

}