package com.gsm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsm.dao.CourseDao;
import com.gsm.entity.*;
import com.gsm.dao.SubjectDao;
import com.gsm.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 科目(Subject)表服务实现类
 */
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private CourseDao courseDao;

    @Override
    public Result selectSubjects() {
        List<Subject> list = subjectDao.selectSubjects();
        Result result = new Result(true, StatusCode.OK, "", list);
        return result;
    }

    @Override
    public Result selectSubjectAndDetailsAndCourseList(Long subjectId) {
        Subject subject = subjectDao.selectSubjectAndDetails(subjectId);
        List<Course> courseList = courseDao.selectCourseListBySubjectId(subjectId);
        subject.setCourseList(courseList);
        Result result = new Result(true, StatusCode.OK, "", subject);
        return result;
    }
}