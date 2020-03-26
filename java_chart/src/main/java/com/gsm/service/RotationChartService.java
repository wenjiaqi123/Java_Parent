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

    Result selectCharts(RotationChart chart);

    Result insertChart(RotationChart chart);

    Result updateChartStatus(Long chartId, Integer status);

    Result updateChart(RotationChart chart);

    Result deleteByChartId(Long chartId);
}