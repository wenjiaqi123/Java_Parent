package com.gsm.dao;

import com.gsm.entity.Course;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 课程(Course)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 21:57:13
 */
public interface CourseDao {

    List<Course> courseLists(Course course);

}