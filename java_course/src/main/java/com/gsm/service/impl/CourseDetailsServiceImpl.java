package com.gsm.service.impl;

import com.gsm.entity.CourseDetails;
import com.gsm.dao.CourseDetailsDao;
import com.gsm.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程细节(CourseDetails)表服务实现类
 */
@Service("courseDetailsService")
public class CourseDetailsServiceImpl implements CourseDetailsService {
    @Autowired
    private CourseDetailsDao courseDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param courseDetailsId 主键
     * @return 实例对象
     */
    @Override
    public CourseDetails queryById(Long courseDetailsId) {
        return this.courseDetailsDao.queryById(courseDetailsId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CourseDetails> queryAllByLimit(int offset, int limit) {
        return this.courseDetailsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param courseDetails 实例对象
     * @return 实例对象
     */
    @Override
    public CourseDetails insert(CourseDetails courseDetails) {
        this.courseDetailsDao.insert(courseDetails);
        return courseDetails;
    }

    /**
     * 修改数据
     *
     * @param courseDetails 实例对象
     * @return 实例对象
     */
    @Override
    public CourseDetails update(CourseDetails courseDetails) {
        this.courseDetailsDao.update(courseDetails);
        return this.queryById(courseDetails.getCourseDetailsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param courseDetailsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long courseDetailsId) {
        return this.courseDetailsDao.deleteById(courseDetailsId) > 0;
    }
}