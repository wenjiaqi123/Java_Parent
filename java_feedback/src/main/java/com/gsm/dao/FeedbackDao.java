package com.gsm.dao;

import com.gsm.entity.Feedback;

/**
 * 建议反馈表(Feedback)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 22:12:02
 */
public interface FeedbackDao {

    int insertFeedBack(Feedback feedback);
}