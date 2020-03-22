package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 问题和答案(QuestionAnswer)实体类
 *
 * @author makejava
 * @since 2020-03-22 10:19:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionAnswer{
    /**
    * 问题主键Id
    */
    private Integer id;
    /**
    * 问题描述
    */
    private String question;
    /**
    * 问题Url
    */
    private String questionUrl;
    /**
    * 答案
    */
    private String answer;
    /**
    * 答案Url
    */
    private String answerUrl;

}