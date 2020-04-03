package com.gsm;

import com.gsm.utils.IdUtils;
import com.gsm.utils.JwtUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;

//  @EnableDiscoveryClient  发现服务
//  @EnableFeignClients  采用 Feign方式发现服务
@EnableDiscoveryClient
@EnableFeignClients(defaultConfiguration = FeignClientsConfiguration.class)
//扫描持久层接口
@MapperScan("com.gsm.dao")
//标识该服务为 Eureka 客户端
@EnableEurekaClient
@SpringBootApplication
public class JavaLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLoginApplication.class);
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

    @Bean
    public JwtUtils getJwt(){
        return new JwtUtils();
    }
}
