package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 科目(Subject)实体类
 *
 * @author makejava
 * @since 2020-03-25 21:19:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject{
    /**
    * 主键Id
    */
    private Long subjectId;
    /**
    * 科目名称
    */
    private String subjectName;
    /**
     * 排序顺序
     */
    private Integer showOrder;
    /**
    * 状态  1在用  0失效
    */
    private Integer status;

    private SubjectDetails subjectDetails;

    private List<Course> courseList;
}