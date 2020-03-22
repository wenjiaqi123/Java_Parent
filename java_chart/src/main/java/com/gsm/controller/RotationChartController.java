package com.gsm.controller;

import com.gsm.entity.RotationChart;
import com.gsm.service.RotationChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 轮播图(RotationChart)表控制层
 *
 * @author makejava
 * @since 2020-03-22 10:17:41
 */
@RestController
@RequestMapping("rotationChart")
public class RotationChartController {
    @Autowired
    private RotationChartService rotationChartService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RotationChart selectOne(Integer id) {
        return this.rotationChartService.queryById(id);
    }

}