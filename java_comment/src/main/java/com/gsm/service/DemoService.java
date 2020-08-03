package com.gsm.service;

import com.gsm.entity.Comment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DemoService {
    String insertDemo(Comment comment);

    String deleteDemo(Comment comment);

    String updateDemo(Comment comment);

    Comment selectDemo(Comment comment);

    List<Comment> selectDemos(Comment comment);

    Page<Comment> selectPageDemos(Integer page, Integer rows, Comment comment);

    String updateLikeNum(String id);
}
