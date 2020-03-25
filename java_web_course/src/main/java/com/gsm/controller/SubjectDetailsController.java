package com.gsm.controller;

import com.gsm.entity.SubjectDetails;
import com.gsm.service.SubjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 科目介绍(SubjectDetails)表控制层
 *
 * @author makejava
 * @since 2020-03-25 21:43:04
 */
@RestController
@RequestMapping("subjectDetails")
public class SubjectDetailsController {
    @Autowired
    private SubjectDetailsService subjectDetailsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SubjectDetails selectOne(Long id) {
        return this.subjectDetailsService.queryById(id);
    }

}