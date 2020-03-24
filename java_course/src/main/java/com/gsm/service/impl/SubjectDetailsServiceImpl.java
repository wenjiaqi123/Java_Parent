package com.gsm.service.impl;

import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.entity.SubjectDetails;
import com.gsm.dao.SubjectDetailsDao;
import com.gsm.service.SubjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 科目介绍(SubjectDetails)表服务实现类
 */
@Service("subjectDetailsService")
public class SubjectDetailsServiceImpl implements SubjectDetailsService {
    @Autowired
    private SubjectDetailsDao subjectDetailsDao;

    @Override
    public Result selectSubjectDetails(Long subjectId) {
        SubjectDetails details = subjectDetailsDao.selectSubjectDetailsBySubjectId(subjectId);
        Result result = new Result(true, StatusCode.OK,"",details);
        return result;
    }
}