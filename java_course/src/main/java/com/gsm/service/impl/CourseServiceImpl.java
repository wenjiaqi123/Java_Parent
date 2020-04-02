package com.gsm.service.impl;

import com.gsm.dao.CourseDao;
import com.gsm.dao.CourseDataDao;
import com.gsm.dao.CourseDetailsDao;
import com.gsm.dao.SubjectDetailsDao;
import com.gsm.entity.*;
import com.gsm.service.CourseService;
import com.gsm.utils.IdUtils;
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
    private CourseDetailsDao courseDetailsDao;
    @Autowired
    private CourseDataDao courseDataDao;
    @Autowired
    private SubjectDetailsDao subjectDetailsDao;
    @Autowired
    private IdUtils idUtils;

    @Override
    public Result selectCourseLists(Course course) {
        List<Course> list = courseDao.selectCourseLists(course);
        Result result = new Result(true, StatusCode.OK, "", list);
        return result;
    }

    @Override
    public Result selectCourseAndDetailsAndData(Long courseId) {
        Course course = courseDao.selectCourseAndDetails(courseId);
        List<CourseData> courseDataList = courseDataDao.selectCourseDataListByCourseId(course.getCourseId());
        course.setCourseDataList(courseDataList);
        Result result = new Result(true, StatusCode.OK, "", course);
        return result;
    }

    @Override
    public Result deleteCourseById(Long courseId) {
        Course course = courseDao.selectCourseByCourseId(courseId);
        //删除课时
        courseDao.deleteCourseById(courseId);
        //删除课时详细信息
        courseDetailsDao.deleteCourseDetailsByCourseId(courseId);
        //删除课时资料
        courseDataDao.deleteCourseDataByCourseId(courseId);
        //减少课程总数
        subjectDetailsDao.delOneTotalBySubjectId(course.getSubjectId());
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result insertCourse(Course course) {
        //课时id
        Long courseId = idUtils.nextId();
        course.setCourseId(courseId);
        Course tempCourse = courseDao.selectCourseBySubjectId(course.getSubjectId());
        if (tempCourse == null) {
            course.setShowOrder(0);
        } else {
            course.setShowOrder(tempCourse.getShowOrder() + 1);
        }
        //插入课时
        courseDao.insertCourse(course);
        CourseDetails courseDetails = course.getCourseDetails();
        courseDetails.setCourseDetailsId(idUtils.nextId());
        courseDetails.setCourseId(course.getCourseId());
        //插入课时详细
        courseDetailsDao.insertCourseDetails(courseDetails);
        List<CourseData> courseDataList = course.getCourseDataList();
        if (courseDataList.size() > 0) {
            courseDataList.forEach(i -> {
                i.setCourseDataId(idUtils.nextId());
                i.setCourseId(courseId);
            });
            //插入课程资料
            courseDataDao.insertCourseDataList(courseDataList);
        }
        //添加课程课时数
        subjectDetailsDao.addOneTotalBySubjectId(course.getSubjectId());
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result updateCourseAndDetailsAndData(Course course) {
        //更新课时信息
        courseDao.updateCourseByCourseId(course);
        CourseDetails courseDetails = course.getCourseDetails();
        courseDetails.setCourseId(course.getCourseId());
        //更新课时详细信息
        courseDetailsDao.updateCourseDetailsByCourseId(course.getCourseDetails());
        //更新资料
        List<CourseData> courseDataList = course.getCourseDataList();
        courseDataList.forEach(i -> {
            i.setCourseDataId(idUtils.nextId());
        });
        courseDataDao.deleteCourseDataByCourseId(course.getCourseId());
        if (courseDataList.size() > 0) {
            courseDataDao.insertCourseDataList(courseDataList);
        }
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result updateStatus(Long courseId, Integer status) {
        Course course = new Course();
        course.setCourseId(courseId);
        course.setStatus(status);
        courseDao.updateSubject(course);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }
}