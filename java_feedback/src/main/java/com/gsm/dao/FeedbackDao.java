package com.gsm.dao;

import com.gsm.entity.Feedback;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 建议反馈表(Feedback)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 22:12:02
 */
public interface FeedbackDao {

    /**
     * 通过ID查询单条数据
     *
     * @param feedbackId 主键
     * @return 实例对象
     */
    Feedback queryById(Long feedbackId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Feedback> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param feedback 实例对象
     * @return 对象列表
     */
    List<Feedback> queryAll(Feedback feedback);

    /**
     * 新增数据
     *
     * @param feedback 实例对象
     * @return 影响行数
     */
    int insert(Feedback feedback);

    /**
     * 修改数据
     *
     * @param feedback 实例对象
     * @return 影响行数
     */
    int update(Feedback feedback);

    /**
     * 通过主键删除数据
     *
     * @param feedbackId 主键
     * @return 影响行数
     */
    int deleteById(Long feedbackId);

}