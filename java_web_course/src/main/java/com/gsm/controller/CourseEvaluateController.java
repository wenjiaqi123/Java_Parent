package com.gsm.controller;

import com.gsm.entity.CourseEvaluate;
import com.gsm.entity.Result;
import com.gsm.entity.Subject;
import com.gsm.service.CourseEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 课程评价(CourseEvaluate)表控制层
 *
 * @author makejava
 * @since 2020-03-26 19:57:58
 */
@RestController
@RequestMapping("evaluate")
public class CourseEvaluateController {
    @Autowired
    private CourseEvaluateService courseEvaluateService;

    //新增课程
    @PostMapping("evaluate/{courseId}/{userId}")
    public Result insertCourseEvaluate(@PathVariable("courseId")Long courseId,@PathVariable("userId")Long userId,@RequestBody CourseEvaluate evaluate) {
        evaluate.setCourseId(courseId);
        evaluate.setUserId(userId);
        Result result = courseEvaluateService.insertCourseEvaluate(evaluate);
        return result;
    }

}