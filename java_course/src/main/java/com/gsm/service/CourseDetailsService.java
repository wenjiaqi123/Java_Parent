package com.gsm.service;

import com.gsm.entity.CourseDetails;
import java.util.List;

/**
 * 课程细节(CourseDetails)表服务接口
 *
 * @author makejava
 * @since 2020-03-25 00:12:32
 */
public interface CourseDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param courseDetailsId 主键
     * @return 实例对象
     */
    CourseDetails queryById(Long courseDetailsId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CourseDetails> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param courseDetails 实例对象
     * @return 实例对象
     */
    CourseDetails insert(CourseDetails courseDetails);

    /**
     * 修改数据
     *
     * @param courseDetails 实例对象
     * @return 实例对象
     */
    CourseDetails update(CourseDetails courseDetails);

    /**
     * 通过主键删除数据
     *
     * @param courseDetailsId 主键
     * @return 是否成功
     */
    boolean deleteById(Long courseDetailsId);

}