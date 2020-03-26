package com.gsm.service.impl;

import com.gsm.dao.CourseDataDao;
import com.gsm.entity.Course;
import com.gsm.dao.CourseDao;
import com.gsm.entity.CourseData;
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
    @Autowired
    private CourseDataDao courseDataDao;

    @Override
    public Result selectCourseAndDetailsAndData(Long courseId) {
        Course course = courseDao.selectCourseAndDetails(courseId);
        List<CourseData> courseDataList = courseDataDao.selectCourseDataListByCourseId(course.getCourseId());
        course.setCourseDataList(courseDataList);
        Result result = new Result(true, StatusCode.OK, "", course);
        return result;
    }
}