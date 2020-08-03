package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/**
 * 把一个javabean声明为 mongodb的文档(行)，通过 collection参数指定这个类对象的文档
 * @Document(collection = "mongodb对应的collection名") 如果省略就默认使用类型小写映射集合
 * @CompoundIndex(def = "{'userId':1,'nickName':-1}") 组合索引
 */
@Document(collection = "comment")
//复合索引
//@CompoundIndex(def = "{'userId':1,'nickName':-1}")
public class Comment implements Serializable {
    //@Id 主键标识，该属性的值自动对应mongodb的主键id，如果该属性名就叫id，该注解可以省略
    @Id
    private String id;
    //该属性对应mongodb字段，如果一致， 注解可以省略
    @Field("content")
    private String content;//吐槽内容
    //添加一个单字段的索引
    @Indexed
    private String userId;//用户id
    private String nickName;//用户昵称
    private LocalDateTime createDate;//创建时间
    private Integer likeNum;//点赞数
    private Integer replyNum;//回复数
    private String state;//状态
    private String parentId;//上级id
    private String articleId;//文章id
}