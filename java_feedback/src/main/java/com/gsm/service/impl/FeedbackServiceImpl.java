package com.gsm.service.impl;

import com.gsm.dao.FeedbackDao;
import com.gsm.entity.Feedback;
import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.service.FeedbackService;
import com.gsm.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 建议反馈表(Feedback)表服务实现类
 */
@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;
    @Autowired
    private IdUtils idUtils;

    @Override
    public Result insertFeedBack(Feedback feedback) {
        long feedbackId = idUtils.nextId();
        feedback.setFeedbackId(feedbackId);
        feedback.setStatus(1);
        feedbackDao.insertFeedBack(feedback);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }
}