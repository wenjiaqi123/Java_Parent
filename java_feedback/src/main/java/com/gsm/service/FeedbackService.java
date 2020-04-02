package com.gsm.service;

import com.gsm.entity.Feedback;
import com.gsm.entity.Result;

/**
 * 建议反馈表(Feedback)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 22:12:02
 */
public interface FeedbackService {

    Result insertFeedBack(Feedback feedback);
}