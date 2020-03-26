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

    //查询课时和课时详细 列表
    @GetMapping("/courseLists")
    public Result selectCourseAndDetailsLists(Course course) {
        Result result = courseService.selectCourseLists(course);
        return result;
    }

    //根据课时id查询课时和详细和资料
    @GetMapping("/courseAndDetailsAndData/{courseId}")
    public Result selectCourseAndDetailsAndData(@PathVariable("courseId")Long courseId) {
        Result result = courseService.selectCourseAndDetailsAndData(courseId);
        return result;
    }

    //根据id修改课时和详细和资料
    @PutMapping("/courseAndDetailsAndData/{courseId}")
    public Result updateCourseAndDetailsAndData(@PathVariable("courseId")Long courseId,@RequestBody Course course) {
        course.setCourseId(courseId);
        Result result = courseService.updateCourseAndDetailsAndData(course);
        return result;
    }

    //根据id修改课时在用状态
    @PutMapping("course/{courseId}/{status}")
    public Result updateStatus(@PathVariable("courseId")Long courseId,@PathVariable("status")Integer status) {
        Result result = courseService.updateStatus(courseId,status);
        return result;
    }

    //添加课时和详细和资料
    @PostMapping("/course")
    public Result insertCourse(@RequestBody Course course) {
        Result result = courseService.insertCourse(course);
        return result;
    }

    //删除课时
    @DeleteMapping("/course/{courseId}")
    public Result deleteCourseById(@PathVariable("courseId")Long courseId) {
        Result result = courseService.deleteCourseById(courseId);
        return result;
    }
}