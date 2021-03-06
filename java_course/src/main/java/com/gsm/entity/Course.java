package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 课程(Course)实体类
 *
 * @author makejava
 * @since 2020-03-24 21:57:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course{
    /**
    * id
    */
    private Long courseId;
    /**
    * 课程名称
    */
    private String courseName;
    /**
    * 所属科目
    */
    private Long subjectId;
    /**
    * 排序顺序
    */
    private Integer showOrder;
    /**
    * 1在用  0失效
    */
    private int status;

    private CourseDetails courseDetails;
    private List<CourseData> courseDataList;
}