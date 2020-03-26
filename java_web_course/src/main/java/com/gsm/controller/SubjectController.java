package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.entity.Subject;
import com.gsm.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 科目(Subject)表控制层
 *
 * @author makejava
 * @since 2020-03-25 21:19:38
 */
@RestController
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;


    //根据状态查询课程
    @GetMapping("subjects")
    public Result selectSubjects() {
        Result result = subjectService.selectSubjects();
        return result;
    }

    //根据id查询课程详细信息列表
    @GetMapping("subjectInfo/{subjectId}")
    public Result selectSubjectAndDetailsAndCourseList(@PathVariable("subjectId")Long subjectId) {
        Result result = subjectService.selectSubjectAndDetailsAndCourseList(subjectId);
        return result;
    }

}