package com.gsm.service;


import com.gsm.entity.Result;

/**
 * 科目介绍(SubjectDetails)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 23:05:36
 */
public interface SubjectDetailsService {

    Result selectSubjectDetails(Long subjectId);

}