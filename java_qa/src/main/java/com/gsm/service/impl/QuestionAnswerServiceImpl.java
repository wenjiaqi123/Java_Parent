package com.gsm.service.impl;

import com.gsm.entity.QuestionAnswer;
import com.gsm.dao.QuestionAnswerDao;
import com.gsm.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 问题和答案(QuestionAnswer)表服务实现类
 */
@Service("questionAnswerService")
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
    @Autowired
    private QuestionAnswerDao questionAnswerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public QuestionAnswer queryById(Integer id) {
        return this.questionAnswerDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<QuestionAnswer> queryAllByLimit(int offset, int limit) {
        return this.questionAnswerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param questionAnswer 实例对象
     * @return 实例对象
     */
    @Override
    public QuestionAnswer insert(QuestionAnswer questionAnswer) {
        this.questionAnswerDao.insert(questionAnswer);
        return questionAnswer;
    }

    /**
     * 修改数据
     *
     * @param questionAnswer 实例对象
     * @return 实例对象
     */
    @Override
    public QuestionAnswer update(QuestionAnswer questionAnswer) {
        this.questionAnswerDao.update(questionAnswer);
        return this.queryById(questionAnswer.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.questionAnswerDao.deleteById(id) > 0;
    }
}