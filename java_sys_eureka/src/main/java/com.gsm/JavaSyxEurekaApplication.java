package com.gsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//标识该服务为 Eureka 服务器
@EnableEurekaServer
@SpringBootApplication
public class JavaSyxEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSyxEurekaApplication.class);
    }
}
