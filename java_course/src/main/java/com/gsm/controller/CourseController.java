package com.gsm.controller;

import com.gsm.entity.Course;
import com.gsm.entity.Result;
import com.gsm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 课程(Course)表控制层
 *
 * @author makejava
 * @since 2020-03-24 21:57:13
 */
@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("courseLists/{page}/{rows}")
    public Result courseLists(@PathVariable("page")Integer page, @PathVariable("rows")Integer rows, Course course) {
        Result result = courseService.courseLists(page,rows,course);
        return result;
    }

}