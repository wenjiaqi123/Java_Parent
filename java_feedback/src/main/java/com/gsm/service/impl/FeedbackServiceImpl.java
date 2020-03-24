package com.gsm.service.impl;

import com.gsm.entity.Feedback;
import com.gsm.dao.FeedbackDao;
import com.gsm.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 建议反馈表(Feedback)表服务实现类
 */
@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;

    /**
     * 通过ID查询单条数据
     *
     * @param feedbackId 主键
     * @return 实例对象
     */
    @Override
    public Feedback queryById(Long feedbackId) {
        return this.feedbackDao.queryById(feedbackId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Feedback> queryAllByLimit(int offset, int limit) {
        return this.feedbackDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    @Override
    public Feedback insert(Feedback feedback) {
        this.feedbackDao.insert(feedback);
        return feedback;
    }

    /**
     * 修改数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    @Override
    public Feedback update(Feedback feedback) {
        this.feedbackDao.update(feedback);
        return this.queryById(feedback.getFeedbackId());
    }

    /**
     * 通过主键删除数据
     *
     * @param feedbackId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long feedbackId) {
        return this.feedbackDao.deleteById(feedbackId) > 0;
    }
}