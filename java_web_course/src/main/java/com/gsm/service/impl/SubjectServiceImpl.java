package com.gsm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsm.entity.PageResult;
import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.entity.Subject;
import com.gsm.dao.SubjectDao;
import com.gsm.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 科目(Subject)表服务实现类
 */
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public Result selectSubjects() {
        List<Subject> list = subjectDao.selectSubjects();
        Result result = new Result(true, StatusCode.OK, "", list);
        return result;
    }
}