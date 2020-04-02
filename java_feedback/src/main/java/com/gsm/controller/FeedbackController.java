package com.gsm.controller;

import com.gsm.entity.Feedback;
import com.gsm.entity.Result;
import com.gsm.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 建议反馈表(Feedback)表控制层
 *
 * @author makejava
 * @since 2020-03-24 22:12:02
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedback")
    public Result insertFeedback(@RequestBody Feedback feedback){
        Result result = feedbackService.insertFeedBack(feedback);
        return result;
    }

}