package com.gsm;


import com.gsm.utils.IdUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//标识该服务为 Eureka 客户端
@EnableEurekaClient
@SpringBootApplication
//
@EnableMongoRepositories(basePackages = {"com.gsm.dao"})
public class JavaCommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCommentApplication.class);
    }

    /**
     * 使用时将 IdUtils 引入
     * @Autowired
     * private IdUtils idUtils;
     */
    @Bean
    public IdUtils getId(){
        return new IdUtils(1,1);
    }

}
