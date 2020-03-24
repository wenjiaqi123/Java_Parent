package com.gsm.controller;

import com.gsm.entity.Course;
import com.gsm.entity.Result;
import com.gsm.entity.Subject;
import com.gsm.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 科目(Subject)表控制层
 *
 * @author makejava
 * @since 2020-03-24 21:55:05
 */
@RestController
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("subjects/{page}/{rows}")
    public Result selectSubjects(@PathVariable("page")Integer page, @PathVariable("rows")Integer rows, Subject subject) {
        Result result = subjectService.selectSubjects(page,rows,subject);
        return result;
    }

    @GetMapping("subject/{subjectId}")
    public Result selectSubjectAndDetailsBySubjectId(@PathVariable("subjectId")Long subjectId) {
        Result result = subjectService.selectSubjectAndDetailsBySubjectId(subjectId);
        return result;
    }

    @DeleteMapping("subject/{subjectId}")
    public Result deleteSubjectById(@PathVariable("subjectId")Long subjectId) {
        Result result = subjectService.deleteSubjectById(subjectId);
        return result;
    }

    @PutMapping("subject/{subjectId}/{status}")
    public Result updateStatus(@PathVariable("subjectId")Long subjectId,@PathVariable("status")Integer status) {
        Result result = subjectService.updateStatus(subjectId,status);
        return result;
    }
}