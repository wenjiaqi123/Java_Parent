package com.gsm.controller;

import com.gsm.entity.CourseDetails;
import com.gsm.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 课程细节(CourseDetails)表控制层
 *
 * @author makejava
 * @since 2020-03-25 00:12:32
 */
@RestController
@RequestMapping("courseDetails")
public class CourseDetailsController {
    @Autowired
    private CourseDetailsService courseDetailsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CourseDetails selectOne(Long id) {
        return this.courseDetailsService.queryById(id);
    }

}