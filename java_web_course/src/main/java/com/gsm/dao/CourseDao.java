package com.gsm.dao;

import com.gsm.entity.Course;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 课程(Course)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-25 21:20:02
 */
public interface CourseDao {

    List<Course> selectCourseListBySubjectId(Long subjectId);

    Course selectCourseAndDetails(Long courseId);
}