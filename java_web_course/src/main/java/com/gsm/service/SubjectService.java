package com.gsm.service;

import com.gsm.entity.Result;
import com.gsm.entity.Subject;
import java.util.List;

/**
 * 科目(Subject)表服务接口
 *
 * @author makejava
 * @since 2020-03-25 21:19:38
 */
public interface SubjectService {

    Result selectSubjects();

    Result selectSubjectAndDetailsAndCourseList(Long subjectId);
}