package com.gsm.service;

import com.gsm.entity.CourseEvaluate;
import com.gsm.entity.Result;

import java.util.List;

/**
 * 课程评价(CourseEvaluate)表服务接口
 *
 * @author makejava
 * @since 2020-03-26 19:57:58
 */
public interface CourseEvaluateService {
    Result insertCourseEvaluate(CourseEvaluate evaluate);
}