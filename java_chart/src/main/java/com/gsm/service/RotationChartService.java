package com.gsm.service;

import com.gsm.entity.Result;
import com.gsm.entity.RotationChart;
import java.util.List;

/**
 * 轮播图(RotationChart)表服务接口
 *
 * @author makejava
 * @since 2020-03-23 15:02:30
 */
public interface RotationChartService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RotationChart queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RotationChart> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param rotationChart 实例对象
     * @return 实例对象
     */
    RotationChart insert(RotationChart rotationChart);

    /**
     * 修改数据
     *
     * @param rotationChart 实例对象
     * @return 实例对象
     */
    RotationChart update(RotationChart rotationChart);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Result selectCharts(Integer page, Integer rows, RotationChart chart);
}