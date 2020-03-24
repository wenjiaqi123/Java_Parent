package com.gsm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsm.dao.SubjectDetailsDao;
import com.gsm.entity.*;
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
    @Autowired
    private SubjectDetailsDao subjectDetailsDao;

    @Override
    public Result selectSubjects(Integer page, Integer rows, Subject subject) {
        PageHelper.startPage(page, rows);
        List<Subject> list = subjectDao.selectSubjects(subject);
        PageInfo<Subject> pageInfo = new PageInfo<>(list);
        Result result = new Result(true, StatusCode.OK, "", new PageResult<>(pageInfo.getTotal(), pageInfo.getList()));
        return result;
    }

    @Override
    public Result selectSubjectAndDetailsBySubjectId(Long subjectId) {
        Subject subject = subjectDao.selectSubjectBySubjectId(subjectId);
        if (subject != null) {
            Long subjectSubjectId = subject.getSubjectId();
            SubjectDetails subjectDetails = subjectDetailsDao.selectSubjectDetailsById(subjectSubjectId);
            subject.setSubjectDetails(subjectDetails);
        }
        Result result = new Result(true, StatusCode.OK, "", subject);
        return result;
    }

    @Override
    public Result deleteSubjectById(Long subjectId) {
        subjectDao.deleteSubjectById(subjectId);
        subjectDetailsDao.deleteSubjectDetailsBySubjectId(subjectId);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result updateStatus(Long subjectId, Integer status) {
        Subject subject = new Subject();
        subject.setSubjectId(subjectId);
        subject.setStatus(status);
        subjectDao.updateSubject(subject);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }
}