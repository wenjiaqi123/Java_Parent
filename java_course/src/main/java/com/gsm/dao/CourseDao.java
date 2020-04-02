package com.gsm.dao;

import com.gsm.entity.Course;

import java.util.List;

/**
 * 课程(Course)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 21:57:13
 */
public interface CourseDao {

    List<Course> selectCourseLists(Course course);

    Course selectCourseAndDetails(Long courseId);

    int deleteCourseById(Long courseId);

    int insertCourse(Course course);

    Course selectCourseByCourseId(Long courseId);

    int updateCourseByCourseId(Course course);

    int updateSubject(Course course);

    Course selectCourseBySubjectId(Long subjectId);
}