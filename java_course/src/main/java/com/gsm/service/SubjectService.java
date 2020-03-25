package com.gsm.service;

import com.gsm.entity.Result;
import com.gsm.entity.Subject;

/**
 * 科目(Subject)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 21:55:05
 */
public interface SubjectService {

    Result selectSubjects(Integer page, Integer rows, Subject subject);

    Result selectSubjectAndDetailsBySubjectId(Long subjectId);

    Result insertSubjectAndDetails(Subject subject);

    Result deleteSubjectById(Long subjectId);

    Result updateStatus(Long subjectId, Integer status);

    Result updateSubjectAndDetails(Subject subject);
}