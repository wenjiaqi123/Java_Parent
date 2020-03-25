package com.gsm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsm.dao.SubjectDetailsDao;
import com.gsm.entity.*;
import com.gsm.dao.SubjectDao;
import com.gsm.service.SubjectService;
import com.gsm.utils.IdUtils;
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
    @Autowired
    private IdUtils idUtils;

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
            SubjectDetails subjectDetails = subjectDetailsDao.selectSubjectDetailsBySubjectId(subjectSubjectId);
            subject.setSubjectDetails(subjectDetails);
        }
        Result result = new Result(true, StatusCode.OK, "", subject);
        return result;
    }

    @Override
    public Result insertSubjectAndDetails(Subject subject) {
        Long subjectId = idUtils.nextId();
        subject.setSubjectId(subjectId);
        //插入课程
        subjectDao.insertSubject(subject);
        SubjectDetails subjectDetails = subject.getSubjectDetails();
        subjectDetails.setSubjectDetailsId(idUtils.nextId());
        subjectDetails.setSubjectId(subjectId);
        subjectDetails.setSubTotal(0);
        //插入课程详细信息
        subjectDetailsDao.insertSubjectDetails(subjectDetails);
        Result result = new Result(true, StatusCode.OK);
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

    @Override
    public Result updateSubjectAndDetails(Subject subject) {
        //更新课程信息
        subjectDao.updateSubject(subject);
        SubjectDetails subjectDetails = subject.getSubjectDetails();
        subjectDetails.setSubjectId(subject.getSubjectId());
        //更新课程详细信息
        subjectDetailsDao.updateSubjectDetails(subjectDetails);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }
}