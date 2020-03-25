package com.gsm.dao;

import com.gsm.entity.CourseDetails;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 课程细节(CourseDetails)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-25 00:12:32
 */
public interface CourseDetailsDao {

    int deleteCourseDetailsByCourseDetailsId(Long courseDetailsId);
    int deleteCourseDetailsByCourseId(Long courseId);

    int insertCourseDetails(CourseDetails courseDetails);

    int updateCourseDetailsByCourseId(CourseDetails courseDetails);
}