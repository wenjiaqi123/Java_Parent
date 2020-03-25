package com.gsm.controller;

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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Subject selectOne(Long id) {
        return this.subjectService.queryById(id);
    }

}