package com.gsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//开启配置服务
@EnableConfigServer
@SpringBootApplication
public class JavaSysConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSysConfigApplication.class);
    }
}
