package com.gsm.dao;

import com.gsm.entity.Subject;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 科目(Subject)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-25 21:19:38
 */
public interface SubjectDao {

    List<Subject> selectSubjects();

    Subject selectSubjectAndDetails(Long subjectId);
}