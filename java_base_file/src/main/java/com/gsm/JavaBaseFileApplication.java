package com.gsm;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

//导入 FastDFS 客户端配置
@Import(FdfsClientConfig.class)
@EnableScheduling
//标识该服务为 Eureka 客户端
@EnableEurekaClient
@SpringBootApplication
public class JavaBaseFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaBaseFileApplication.class);
    }
}
