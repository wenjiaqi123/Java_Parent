package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 轮播图(RotationChart)实体类
 *
 * @author makejava
 * @since 2020-03-22 10:17:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RotationChart{
    /**
    * 主键Id
    */
    private Integer id;
    /**
    * 轮播图 URL
    */
    private String chartUrl;
    /**
    * 点击轮播图跳转的链接地址
    */
    private String webUrl;
    /**
    * 状态  1有效  0无效
    */
    private Integer status;

}