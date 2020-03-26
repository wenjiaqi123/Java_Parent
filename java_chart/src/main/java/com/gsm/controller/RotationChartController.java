package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.entity.RotationChart;
import com.gsm.service.RotationChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 轮播图(RotationChart)表控制层
 *
 * @author makejava
 * @since 2020-03-23 15:02:30
 */
@RestController
@RequestMapping("rotationChart")
public class RotationChartController {
    @Autowired
    private RotationChartService rotationChartService;

    /**
     * 新增轮播图
     */
    @PostMapping("chart")
    public Result insertChart(@RequestBody RotationChart chart) {
        Result result = rotationChartService.insertChart(chart);
        return result;
    }

    /**
     * 根据id删除轮播图
     */
    @DeleteMapping("chart/{chartId}")
    public Result deleteByChartId(@PathVariable("chartId")Long chartId) {
        Result result = rotationChartService.deleteByChartId(chartId);
        return result;
    }

    /**
     * 根据id修改轮播图状态
     */
    @PutMapping("chart/{chartId}/{status}")
    public Result updateChartStatus(@PathVariable("chartId")Long chartId,@PathVariable("status")Integer status) {
        Result result = rotationChartService.updateChartStatus(chartId,status);
        return result;
    }

    /**
     * 根据id修改轮播图信息
     */
    @PutMapping("chart/{chartId}")
    public Result updateChart(@PathVariable("chartId")Long chartId,@RequestBody RotationChart chart) {
        chart.setChartId(chartId);
        Result result = rotationChartService.updateChart(chart);
        return result;
    }

    /**
     * 查询轮播图
     */
    @GetMapping("chart")
    public Result selectChart(RotationChart chart) {
        Result result = rotationChartService.selectCharts(chart);
        return result;
    }

}