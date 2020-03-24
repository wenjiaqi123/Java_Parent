package com.gsm.dao;

import com.gsm.entity.Subject;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 科目(Subject)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 21:55:05
 */
public interface SubjectDao {
    List<Subject> selectSubjects(Subject subject);

    Subject selectSubjectBySubjectId(Long subjectId);

    int deleteSubjectById(Long subjectId);

    int updateSubject(Subject subject);
}