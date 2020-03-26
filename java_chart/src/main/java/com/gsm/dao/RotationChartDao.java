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

    int insertChart(RotationChart chart);

    int deleteByChartId(Long chartId);

    int updateChartStatus(RotationChart chart);

    int updateChart(RotationChart chart);

    List<RotationChart> selectCharts(RotationChart chart);
}