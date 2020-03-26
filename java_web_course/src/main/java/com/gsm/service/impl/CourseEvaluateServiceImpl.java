package com.gsm.service.impl;

import com.gsm.entity.CourseEvaluate;
import com.gsm.dao.CourseEvaluateDao;
import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.service.CourseEvaluateService;
import com.gsm.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程评价(CourseEvaluate)表服务实现类
 */
@Service("courseEvaluateService")
public class CourseEvaluateServiceImpl implements CourseEvaluateService {
    @Autowired
    private CourseEvaluateDao courseEvaluateDao;
    @Autowired
    private IdUtils idUtils;

    @Override
    public Result insertCourseEvaluate(CourseEvaluate evaluate) {
        long courseEvaluateId = idUtils.nextId();
        evaluate.setCourseEvaluateId(courseEvaluateId);
        courseEvaluateDao.insertCourseEvaluate(evaluate);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }
}