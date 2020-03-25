package com.gsm.dao;

import com.gsm.entity.SubjectDetails;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 科目介绍(SubjectDetails)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 23:05:36
 */
public interface SubjectDetailsDao {

    SubjectDetails selectSubjectDetailsById(Long subjectDetailsId);
    SubjectDetails selectSubjectDetailsBySubjectId(Long subjectId);

    int insertSubjectDetails(SubjectDetails subjectDetails);

    int updateSubjectDetails(SubjectDetails subjectDetails);

    int deleteSubjectDetailsBySubjectDetailsId(Long subjectDetailsId);

    int deleteSubjectDetailsBySubjectId(Long subjectId);

    int addOneTotalBySubjectId(Long subjectId);

    int delOneTotalBySubjectId(Long subjectId);
}