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
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courseLists")
    public Result selectCourseAndDetailsLists(Course course) {
        Result result = courseService.selectCourseLists(course);
        return result;
    }

    @GetMapping("/courseAndDetailsAndData/{courseId}")
    public Result selectCourseAndDetailsAndData(@PathVariable("courseId")Long courseId) {
        Result result = courseService.selectCourseAndDetailsAndData(courseId);
        return result;
    }

    @PutMapping("/courseAndDetailsAndData/{courseId}")
    public Result updateCourseAndDetailsAndData(@PathVariable("courseId")Long courseId,@RequestBody Course course) {
        course.setCourseId(courseId);
        Result result = courseService.updateCourseAndDetailsAndData(course);
        return result;
    }

    @PostMapping("/course")
    public Result insertCourse(@RequestBody Course course) {
        Result result = courseService.insertCourse(course);
        return result;
    }

    @DeleteMapping("/course/{courseId}")
    public Result deleteCourseById(@PathVariable("courseId")Long courseId) {
        Result result = courseService.deleteCourseById(courseId);
        return result;
    }
}