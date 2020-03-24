package com.gsm.dao;

import com.gsm.entity.CourseDetails;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 课程细节(CourseDetails)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-25 00:12:32
 */
public interface CourseDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param courseDetailsId 主键
     * @return 实例对象
     */
    CourseDetails queryById(Long courseDetailsId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CourseDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param courseDetails 实例对象
     * @return 对象列表
     */
    List<CourseDetails> queryAll(CourseDetails courseDetails);

    /**
     * 新增数据
     *
     * @param courseDetails 实例对象
     * @return 影响行数
     */
    int insert(CourseDetails courseDetails);

    /**
     * 修改数据
     *
     * @param courseDetails 实例对象
     * @return 影响行数
     */
    int update(CourseDetails courseDetails);

    /**
     * 通过主键删除数据
     *
     * @param courseDetailsId 主键
     * @return 影响行数
     */
    int deleteById(Long courseDetailsId);

}