package com.gsm.dao;

import com.gsm.entity.SubjectDetails;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 科目介绍(SubjectDetails)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-25 21:43:04
 */
public interface SubjectDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param subjectDetailsId 主键
     * @return 实例对象
     */
    SubjectDetails queryById(Long subjectDetailsId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SubjectDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param subjectDetails 实例对象
     * @return 对象列表
     */
    List<SubjectDetails> queryAll(SubjectDetails subjectDetails);

    /**
     * 新增数据
     *
     * @param subjectDetails 实例对象
     * @return 影响行数
     */
    int insert(SubjectDetails subjectDetails);

    /**
     * 修改数据
     *
     * @param subjectDetails 实例对象
     * @return 影响行数
     */
    int update(SubjectDetails subjectDetails);

    /**
     * 通过主键删除数据
     *
     * @param subjectDetailsId 主键
     * @return 影响行数
     */
    int deleteById(Long subjectDetailsId);

}