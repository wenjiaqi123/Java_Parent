package com.gsm.dao;

import com.gsm.entity.RotationChart;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 轮播图(RotationChart)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-23 15:02:30
 */
public interface RotationChartDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RotationChart queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RotationChart> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rotationChart 实例对象
     * @return 对象列表
     */
    List<RotationChart> queryAll(RotationChart rotationChart);

    /**
     * 新增数据
     *
     * @param rotationChart 实例对象
     * @return 影响行数
     */
    int insert(RotationChart rotationChart);

    /**
     * 修改数据
     *
     * @param rotationChart 实例对象
     * @return 影响行数
     */
    int update(RotationChart rotationChart);

    List<RotationChart> selectCharts(RotationChart chart);

    void deleteById(Long chartId);
}