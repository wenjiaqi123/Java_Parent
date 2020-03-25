package com.gsm.dao;

import com.gsm.entity.Subject;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 科目(Subject)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-25 21:42:51
 */
public interface SubjectDao {

    /**
     * 通过ID查询单条数据
     *
     * @param subjectId 主键
     * @return 实例对象
     */
    Subject queryById(Long subjectId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Subject> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param subject 实例对象
     * @return 对象列表
     */
    List<Subject> queryAll(Subject subject);

    /**
     * 新增数据
     *
     * @param subject 实例对象
     * @return 影响行数
     */
    int insert(Subject subject);

    /**
     * 修改数据
     *
     * @param subject 实例对象
     * @return 影响行数
     */
    int update(Subject subject);

    /**
     * 通过主键删除数据
     *
     * @param subjectId 主键
     * @return 影响行数
     */
    int deleteById(Long subjectId);

}