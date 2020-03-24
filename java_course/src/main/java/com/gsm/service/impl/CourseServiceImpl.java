package com.gsm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsm.entity.Course;
import com.gsm.dao.CourseDao;
import com.gsm.entity.PageResult;
import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程(Course)表服务实现类
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public Result courseLists(Integer page, Integer rows, Course course) {
        PageHelper.startPage(page,rows);
        List<Course> list = courseDao.courseLists(course);
        PageInfo<Course> pageInfo = new PageInfo<>(list);
        Result result = new Result(true, StatusCode.OK,"",new PageResult<>(pageInfo.getTotal(),pageInfo.getList()));
        return result;
    }
}