package com.gsm.controller;

import com.gsm.entity.Suggestion;
import com.gsm.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 建议反馈表(Suggestion)表控制层
 *
 * @author makejava
 * @since 2020-03-22 10:19:17
 */
@RestController
@RequestMapping("suggestion")
public class SuggestionController {
    @Autowired
    private SuggestionService suggestionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Suggestion selectOne(Integer id) {
        return this.suggestionService.queryById(id);
    }

}