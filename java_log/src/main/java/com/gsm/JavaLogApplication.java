package com.gsm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//扫描持久层接口
@MapperScan("com.gsm.dao")
@SpringBootApplication
public class JavaLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLogApplication.class);
    }

}