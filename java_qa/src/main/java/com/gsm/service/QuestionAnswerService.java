package com.gsm.service;

import com.gsm.entity.QuestionAnswer;
import java.util.List;

/**
 * 问题和答案(QuestionAnswer)表服务接口
 *
 * @author makejava
 * @since 2020-03-22 10:19:46
 */
public interface QuestionAnswerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    QuestionAnswer queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<QuestionAnswer> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param questionAnswer 实例对象
     * @return 实例对象
     */
    QuestionAnswer insert(QuestionAnswer questionAnswer);

    /**
     * 修改数据
     *
     * @param questionAnswer 实例对象
     * @return 实例对象
     */
    QuestionAnswer update(QuestionAnswer questionAnswer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}