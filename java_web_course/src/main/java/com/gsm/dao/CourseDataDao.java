package com.gsm.dao;

import com.gsm.entity.CourseData;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 课程资料(CourseData)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-26 15:28:51
 */
public interface CourseDataDao {

    List<CourseData> selectCourseDataListByCourseId(Long courseId);
}