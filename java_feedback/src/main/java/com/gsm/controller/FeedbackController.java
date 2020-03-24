package com.gsm.controller;

import com.gsm.entity.Feedback;
import com.gsm.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 建议反馈表(Feedback)表控制层
 *
 * @author makejava
 * @since 2020-03-24 22:12:02
 */
@RestController
@RequestMapping("feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Feedback selectOne(Long id) {
        return this.feedbackService.queryById(id);
    }

}