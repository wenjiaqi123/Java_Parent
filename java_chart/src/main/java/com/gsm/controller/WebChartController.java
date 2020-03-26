package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.entity.RotationChart;
import com.gsm.service.RotationChartService;
import com.gsm.service.WebChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webChart")
public class WebChartController {
    @Autowired
    private WebChartService webChartService;

    /**
     * 查询轮播图
     */
    @GetMapping("chart")
    public Result selectChart(RotationChart chart) {
        Result result = webChartService.selectCharts(chart);
        return result;
    }
}
