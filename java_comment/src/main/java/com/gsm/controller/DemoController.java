package com.gsm.controller;

import com.gsm.entity.Comment;
import com.gsm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment-demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping("comment")
    public String insertDemo(@RequestBody Comment comment) {
        String s = demoService.insertDemo(comment);
        return s;
    }

    @DeleteMapping("comment/{id}")
    public String deleteDemo(@PathVariable("id") String id, Comment comment) {
        comment.setId(id);
        String s = demoService.deleteDemo(comment);
        return s;
    }

    @PutMapping("comment/{id}")
    public String updateDemo(@PathVariable("id") String id, @RequestBody Comment comment) {
        comment.setId(id);
        String s = demoService.updateDemo(comment);
        return s;
    }

    @GetMapping("comment/{id}")
    public Comment selectDemo(@PathVariable("id") String id, Comment comment) {
        comment.setId(id);
        Comment c = demoService.selectDemo(comment);
        return c;
    }

    @GetMapping("commentList")
    public List<Comment> selectDemos(Comment comment) {
        List<Comment> list = demoService.selectDemos(comment);
        return list;
    }

    @GetMapping("commentPageList/{page}/{rows}")
    public Page<Comment> selectPageDemos(@PathVariable("page") Integer page,@PathVariable("rows") Integer rows,Comment comment) {
        Page<Comment> list = demoService.selectPageDemos(page,rows,comment);
        return list;
    }

    @PutMapping("likeNum/{id}")
    public String updateLikeNum(@PathVariable("id") String id) {
        String s = demoService.updateLikeNum(id);
        return s;
    }
}
