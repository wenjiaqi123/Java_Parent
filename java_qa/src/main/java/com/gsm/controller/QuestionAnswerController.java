package com.gsm.controller;

import com.gsm.entity.QuestionAnswer;
import com.gsm.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 问题和答案(QuestionAnswer)表控制层
 *
 * @author makejava
 * @since 2020-03-22 10:19:46
 */
@RestController
@RequestMapping("questionAnswer")
public class QuestionAnswerController {
    @Autowired
    private QuestionAnswerService questionAnswerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public QuestionAnswer selectOne(Integer id) {
        return this.questionAnswerService.queryById(id);
    }

}