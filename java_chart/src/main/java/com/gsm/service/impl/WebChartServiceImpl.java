package com.gsm.service.impl;

import com.gsm.dao.RotationChartDao;
import com.gsm.dao.WebChartDao;
import com.gsm.entity.Result;
import com.gsm.entity.RotationChart;
import com.gsm.entity.StatusCode;
import com.gsm.service.RotationChartService;
import com.gsm.service.WebChartService;
import com.gsm.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 轮播图(RotationChart)表服务实现类
 */
@Service("webChartService")
public class WebChartServiceImpl implements WebChartService {
    @Autowired
    private WebChartDao webChartDao;

    @Override
    public Result selectCharts(RotationChart chart) {
        List<RotationChart> list = webChartDao.selectCharts(chart);
        Result result = new Result(true, StatusCode.OK, "", list);
        return result;
    }
}