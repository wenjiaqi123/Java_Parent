package com.gsm.service;

import com.gsm.entity.Result;
import com.gsm.entity.RotationChart;

/**
 * 轮播图(RotationChart)表服务接口
 *
 * @author makejava
 * @since 2020-03-23 15:02:30
 */
public interface WebChartService {

    Result selectCharts(RotationChart chart);
}