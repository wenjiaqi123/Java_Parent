package com.gsm.dao;

import com.gsm.entity.CourseEvaluate;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 课程评价(CourseEvaluate)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-26 19:57:58
 */
public interface CourseEvaluateDao {

    int insertCourseEvaluate(CourseEvaluate evaluate);
}