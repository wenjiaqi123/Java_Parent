package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.entity.Subject;
import com.gsm.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 科目(Subject)表控制层
 *
 * @author makejava
 * @since 2020-03-24 21:55:05
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    //根据状态查询课程
    @GetMapping("/subjects/{page}/{rows}")
    public Result selectSubjects(@PathVariable("page")Integer page, @PathVariable("rows")Integer rows, Subject subject) {
        Result result = subjectService.selectSubjects(page,rows,subject);
        return result;
    }

    //根据课程id查询课程信息和详细信息
    @GetMapping("/subject/{subjectId}")
    public Result selectSubjectAndDetailsBySubjectId(@PathVariable("subjectId")Long subjectId) {
        Result result = subjectService.selectSubjectAndDetailsBySubjectId(subjectId);
        return result;
    }

    //新增课程
    @PostMapping("/subject")
    public Result insertSubjectAndDetails(@RequestBody Subject subject) {
        Result result = subjectService.insertSubjectAndDetails(subject);
        return result;
    }

    //删除课程
    @DeleteMapping("/subject/{subjectId}")
    public Result deleteSubjectById(@PathVariable("subjectId")Long subjectId) {
        Result result = subjectService.deleteSubjectById(subjectId);
        return result;
    }

    //修改课程状态
    @PutMapping("/subject/{subjectId}/{status}")
    public Result updateStatus(@PathVariable("subjectId")Long subjectId,@PathVariable("status")Integer status) {
        Result result = subjectService.updateStatus(subjectId,status);
        return result;
    }

    //修改课程状态
    @PutMapping("/showOrder")
    public Result updateSubjectShowOrder(@RequestBody List<Subject> list) {
        Result result = subjectService.updateSubjectShowOrder(list);
        return result;
    }

    //修改课程信息
    @PutMapping("/subjectAndDetails/{subjectId}")
    public Result updateSubjectAndDetails(@PathVariable("subjectId")Long subjectId,@RequestBody Subject subject) {
        subject.setSubjectId(subjectId);
        Result result = subjectService.updateSubjectAndDetails(subject);
        return result;
    }
}