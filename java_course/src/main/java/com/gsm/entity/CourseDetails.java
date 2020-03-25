package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程细节(CourseDetails)实体类
 *
 * @author makejava
 * @since 2020-03-25 00:12:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDetails{
    
    private Long courseDetailsId;
    /**
    * 课程 id
    */
    private Long courseId;
    /**
    * 课程视频URL地址
    */
    private String courseUrl;
    /**
    * 课程时长
    */
    private Integer courseTime;
    /**
    * 文件大小
    */
    private Integer courseSize;
    /**
    * 课程平均得分
    */
    private Double courseScore;
    /**
    * 1在用  0失效
    */
    private Integer status;

}