package com.gsm.dao;

import com.gsm.entity.QuestionAnswer;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 问题和答案(QuestionAnswer)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-22 10:19:46
 */
public interface QuestionAnswerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    QuestionAnswer queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<QuestionAnswer> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param questionAnswer 实例对象
     * @return 对象列表
     */
    List<QuestionAnswer> queryAll(QuestionAnswer questionAnswer);

    /**
     * 新增数据
     *
     * @param questionAnswer 实例对象
     * @return 影响行数
     */
    int insert(QuestionAnswer questionAnswer);

    /**
     * 修改数据
     *
     * @param questionAnswer 实例对象
     * @return 影响行数
     */
    int update(QuestionAnswer questionAnswer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}