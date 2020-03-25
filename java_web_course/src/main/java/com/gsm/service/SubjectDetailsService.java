package com.gsm.service;

import com.gsm.entity.SubjectDetails;
import java.util.List;

/**
 * 科目介绍(SubjectDetails)表服务接口
 *
 * @author makejava
 * @since 2020-03-25 21:43:04
 */
public interface SubjectDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param subjectDetailsId 主键
     * @return 实例对象
     */
    SubjectDetails queryById(Long subjectDetailsId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SubjectDetails> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param subjectDetails 实例对象
     * @return 实例对象
     */
    SubjectDetails insert(SubjectDetails subjectDetails);

    /**
     * 修改数据
     *
     * @param subjectDetails 实例对象
     * @return 实例对象
     */
    SubjectDetails update(SubjectDetails subjectDetails);

    /**
     * 通过主键删除数据
     *
     * @param subjectDetailsId 主键
     * @return 是否成功
     */
    boolean deleteById(Long subjectDetailsId);

}