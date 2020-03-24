package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.entity.Subject;
import com.gsm.service.SubjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 科目介绍(SubjectDetails)表控制层
 *
 * @author makejava
 * @since 2020-03-24 23:05:36
 */
@RestController
@RequestMapping("subjectDetails")
public class SubjectDetailsController {
    @Autowired
    private SubjectDetailsService subjectDetailsService;

    @GetMapping("/{subjectId}")
    public Result selectSubjectDetails(@PathVariable("subjectId")Long subjectId) {
        Result result = subjectDetailsService.selectSubjectDetails(subjectId);
        return result;
    }
}