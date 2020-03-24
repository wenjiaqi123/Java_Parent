package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 科目介绍(SubjectDetails)实体类
 *
 * @author makejava
 * @since 2020-03-24 22:37:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectDetails{
    /**
    * 课程id
    */
    private Long subjectDetailsId;
    /**
    * 科目 id
    */
    private Long subjectId;
    /**
    * 科目简介
    */
    private String subIntroduction;
    /**
    * 讲师
    */
    private String subTeacher;
    /**
    * qq群
    */
    private String qqGroup;
    /**
    * 课程图片地址
    */
    private String subPic;
    /**
    * 课时数
    */
    private Integer subTotal;
    /**
    * 科目平均打分
    */
    private Double subScore;
    /**
    * 1在用   0失效
    */
    private Integer status;

}