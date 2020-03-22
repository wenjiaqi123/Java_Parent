package com.gsm.controller;

import com.gsm.entity.Course;
import com.gsm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 课程(Course)表控制层
 *
 * @author makejava
 * @since 2020-03-22 10:18:36
 */
@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Course selectOne(Integer id) {
        return this.courseService.queryById(id);
    }

}