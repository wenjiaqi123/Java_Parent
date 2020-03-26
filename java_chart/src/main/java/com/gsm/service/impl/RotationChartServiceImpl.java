package com.gsm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsm.entity.PageResult;
import com.gsm.entity.Result;
import com.gsm.entity.RotationChart;
import com.gsm.dao.RotationChartDao;
import com.gsm.entity.StatusCode;
import com.gsm.service.RotationChartService;
import com.gsm.utils.IdUtils;
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
    @Autowired
    private IdUtils idUtils;

    @Override
    public Result selectCharts(RotationChart chart) {
        List<RotationChart> list = rotationChartDao.selectCharts(chart);
        Result result = new Result(true, StatusCode.OK, "", list);
        return result;
    }

    @Override
    public Result insertChart(RotationChart chart) {
        long chartId = idUtils.nextId();
        chart.setChartId(chartId);
        rotationChartDao.insertChart(chart);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result updateChartStatus(Long chartId, Integer status) {
        RotationChart chart = new RotationChart();
        chart.setChartId(chartId);
        chart.setStatus(status);
        rotationChartDao.updateChartStatus(chart);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result updateChart(RotationChart chart) {
        rotationChartDao.updateChart(chart);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result deleteByChartId(Long chartId) {
        rotationChartDao.deleteByChartId(chartId);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }
}