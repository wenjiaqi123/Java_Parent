package com.gsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//标识该服务为 Eureka 客户端
@EnableEurekaClient
@SpringBootApplication
public class JavaBaseSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaBaseSmsApplication.class);
    }
}
