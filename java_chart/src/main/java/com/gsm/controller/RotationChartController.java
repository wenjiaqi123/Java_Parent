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
     * 查询轮播图
     */
    @GetMapping("charts/{page}/{rows}")
    public Result selectCharts(@PathVariable("page")Integer page, @PathVariable("rows")Integer rows, RotationChart chart) {
        Result result = rotationChartService.selectCharts(page,rows,chart);
        return result;
    }

    /**
     * 根据id删除轮播图
     */
    @DeleteMapping("chart/{chartId}")
    public Result deleteById(@PathVariable("chartId")Long chartId) {
        Result result = rotationChartService.deleteById(chartId);
        return result;
    }

}