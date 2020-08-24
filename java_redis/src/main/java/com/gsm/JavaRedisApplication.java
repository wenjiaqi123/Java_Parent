package com.gsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @EnableCaching
 */
@EnableCaching
@SpringBootApplication
public class JavaRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaRedisApplication.class);
    }
}
