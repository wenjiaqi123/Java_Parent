package com.gsm.service.impl;

import com.gsm.entity.Suggestion;
import com.gsm.dao.SuggestionDao;
import com.gsm.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 建议反馈表(Suggestion)表服务实现类
 */
@Service("suggestionService")
public class SuggestionServiceImpl implements SuggestionService {
    @Autowired
    private SuggestionDao suggestionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Suggestion queryById(Integer id) {
        return this.suggestionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Suggestion> queryAllByLimit(int offset, int limit) {
        return this.suggestionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param suggestion 实例对象
     * @return 实例对象
     */
    @Override
    public Suggestion insert(Suggestion suggestion) {
        this.suggestionDao.insert(suggestion);
        return suggestion;
    }

    /**
     * 修改数据
     *
     * @param suggestion 实例对象
     * @return 实例对象
     */
    @Override
    public Suggestion update(Suggestion suggestion) {
        this.suggestionDao.update(suggestion);
        return this.queryById(suggestion.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.suggestionDao.deleteById(id) > 0;
    }
}