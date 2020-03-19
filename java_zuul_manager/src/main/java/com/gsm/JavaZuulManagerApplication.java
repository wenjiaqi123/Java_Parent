package com.gsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//网关注解
@EnableZuulProxy
//标识该服务为 Eureka 客户端
@EnableEurekaClient
@SpringBootApplication
public class JavaZuulManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaZuulManagerApplication.class);
    }
}
