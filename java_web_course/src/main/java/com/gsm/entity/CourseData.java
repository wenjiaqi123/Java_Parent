package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程资料(CourseData)实体类
 *
 * @author makejava
 * @since 2020-03-26 09:35:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseData{
    
    private Long courseDataId;
    /**
    * 课程id
    */
    private Long courseId;
    /**
    * 资料名称
    */
    private String dataName;
    /**
    * 资料 URL
    */
    private String dataUrl;
    /**
    * 资料显示顺序排序
    */
    private Integer showOrder;
    /**
    * 状态  0失效
    */
    private Integer status;

}