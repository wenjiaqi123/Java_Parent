package com.gsm.service.impl;

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

    /**
     * 通过ID查询单条数据
     *
     * @param subjectId 主键
     * @return 实例对象
     */
    @Override
    public Subject queryById(Long subjectId) {
        return this.subjectDao.queryById(subjectId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Subject> queryAllByLimit(int offset, int limit) {
        return this.subjectDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param subject 实例对象
     * @return 实例对象
     */
    @Override
    public Subject insert(Subject subject) {
        this.subjectDao.insert(subject);
        return subject;
    }

    /**
     * 修改数据
     *
     * @param subject 实例对象
     * @return 实例对象
     */
    @Override
    public Subject update(Subject subject) {
        this.subjectDao.update(subject);
        return this.queryById(subject.getSubjectId());
    }

    /**
     * 通过主键删除数据
     *
     * @param subjectId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long subjectId) {
        return this.subjectDao.deleteById(subjectId) > 0;
    }
}