package com.gsm.service;

import com.gsm.entity.Course;
import com.gsm.entity.Result;

import java.util.List;

/**
 * 课程(Course)表服务接口
 *
 * @author makejava
 * @since 2020-03-25 21:20:02
 */
public interface CourseService {

    Result selectCourseAndDetailsAndData(Long courseId);
}