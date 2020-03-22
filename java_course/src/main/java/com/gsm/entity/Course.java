package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程(Course)实体类
 *
 * @author makejava
 * @since 2020-03-22 10:18:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course{
    /**
    * id
    */
    private Integer id;
    /**
    * 课程名称
    */
    private String courseName;
    /**
    * 所属科目
    */
    private Integer subjectId;
    /**
    * 排序顺序
    */
    private Integer showOrder;
    /**
    * 1在用  0失效
    */
    private Integer status;

}