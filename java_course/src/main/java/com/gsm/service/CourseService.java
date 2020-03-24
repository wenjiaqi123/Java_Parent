package com.gsm.service;

import com.gsm.entity.Course;
import com.gsm.entity.Result;

import java.util.List;

/**
 * 课程(Course)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 21:57:13
 */
public interface CourseService {

    Result courseLists(Integer page, Integer rows, Course course);

}