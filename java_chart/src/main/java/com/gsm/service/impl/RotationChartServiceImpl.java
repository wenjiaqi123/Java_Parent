package com.gsm.service.impl;

import com.gsm.entity.RotationChart;
import com.gsm.dao.RotationChartDao;
import com.gsm.service.RotationChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 轮播图(RotationChart)表服务实现类
 */
@Service("rotationChartService")
public class RotationChartServiceImpl implements RotationChartService {
    @Autowired
    private RotationChartDao rotationChartDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RotationChart queryById(Integer id) {
        return this.rotationChartDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RotationChart> queryAllByLimit(int offset, int limit) {
        return this.rotationChartDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param rotationChart 实例对象
     * @return 实例对象
     */
    @Override
    public RotationChart insert(RotationChart rotationChart) {
        this.rotationChartDao.insert(rotationChart);
        return rotationChart;
    }

    /**
     * 修改数据
     *
     * @param rotationChart 实例对象
     * @return 实例对象
     */
    @Override
    public RotationChart update(RotationChart rotationChart) {
        this.rotationChartDao.update(rotationChart);
        return this.queryById(rotationChart.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.rotationChartDao.deleteById(id) > 0;
    }
}