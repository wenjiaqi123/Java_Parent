package com.gsm.dao;

import com.gsm.entity.RotationChart;

import java.util.List;

/**
 * 轮播图(RotationChart)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-23 15:02:30
 */
public interface WebChartDao {
    List<RotationChart> selectCharts(RotationChart chart);
}