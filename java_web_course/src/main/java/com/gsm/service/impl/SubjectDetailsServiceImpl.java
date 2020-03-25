package com.gsm.service.impl;

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

    /**
     * 通过ID查询单条数据
     *
     * @param subjectDetailsId 主键
     * @return 实例对象
     */
    @Override
    public SubjectDetails queryById(Long subjectDetailsId) {
        return this.subjectDetailsDao.queryById(subjectDetailsId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SubjectDetails> queryAllByLimit(int offset, int limit) {
        return this.subjectDetailsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param subjectDetails 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectDetails insert(SubjectDetails subjectDetails) {
        this.subjectDetailsDao.insert(subjectDetails);
        return subjectDetails;
    }

    /**
     * 修改数据
     *
     * @param subjectDetails 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectDetails update(SubjectDetails subjectDetails) {
        this.subjectDetailsDao.update(subjectDetails);
        return this.queryById(subjectDetails.getSubjectDetailsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param subjectDetailsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long subjectDetailsId) {
        return this.subjectDetailsDao.deleteById(subjectDetailsId) > 0;
    }
}