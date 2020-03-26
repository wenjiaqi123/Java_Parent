package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程评价(CourseEvaluate)实体类
 *
 * @author makejava
 * @since 2020-03-26 19:57:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseEvaluate{
    /**
    * 主键
    */
    private Long courseEvaluateId;
    /**
    * 课程id
    */
    private Long courseId;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 课程评分
    */
    private Integer courseScore;
    /**
    * 课程评价
    */
    private String courseEvaluate;

}