package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 课程(Course)表控制层
 *
 * @author makejava
 * @since 2020-03-25 21:20:02
 */
@RestController
@RequestMapping("webCourse")
public class CourseController {
    @Autowired
    private CourseService courseService;

    //根据id查询课时信息，详细，资料
    @GetMapping("course/{courseId}")
    public Result selectCourseAndDetailsAndData(@PathVariable("courseId")Long courseId) {
        Result result = courseService.selectCourseAndDetailsAndData(courseId);
        return result;
    }
}