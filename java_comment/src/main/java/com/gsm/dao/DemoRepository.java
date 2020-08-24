package com.gsm.dao;

import com.gsm.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 继承 MongoRepository<实体类类型，id类型>
 */
public interface DemoRepository  extends MongoRepository<Comment,String>{
    Page<Comment> findByState(String state, Pageable pageable);
}