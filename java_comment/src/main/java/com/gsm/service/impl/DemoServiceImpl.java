package com.gsm.service.impl;

import com.gsm.dao.DemoRepository;
import com.gsm.entity.Comment;
import com.gsm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoRepository demoDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String insertDemo(Comment comment) {
        Comment c = Comment.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .nickName(comment.getNickName())
                .createDate(LocalDateTime.now())
                .state(comment.getState())
                .parentId(comment.getParentId())
                .articleId(comment.getArticleId())
                .build();
        demoDao.save(c);
        return "新增成功";
    }

    @Override
    public String deleteDemo(Comment comment) {
        demoDao.deleteById(comment.getId());
        return "删除成功";
    }

    @Override
    public String updateDemo(Comment comment) {
        demoDao.save(comment);
        return "更新成功";
    }

    @Override
    public Comment selectDemo(Comment comment) {
        Optional<Comment> o = demoDao.findById(comment.getId());
        Comment c = o.get();
        return c;
    }

    @Override
    public List<Comment> selectDemos(Comment comment) {
        List<Comment> list = demoDao.findAll();
        return list;
    }

    @Override
    public Page<Comment> selectPageDemos(Integer page, Integer rows, Comment comment) {
        Page<Comment> list = demoDao.findByState(comment.getState(), PageRequest.of(page, rows));
        return list;
    }

    @Override
    public String updateLikeNum(String id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("likeNum",1);
        mongoTemplate.updateFirst(query,update,Comment.class);
        return "点赞成功";
    }
}