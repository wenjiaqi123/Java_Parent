package com.gsm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//扫描持久层接口
@MapperScan("com.gsm.dao")
//标识该服务为 Eureka 客户端
@EnableEurekaClient
@SpringBootApplication
public class JavaWebCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaWebCourseApplication.class);
    }
}
