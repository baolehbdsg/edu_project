package com.hebin.edu.resourse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
@MapperScan(basePackages = "com.hebin.edu.resourse.dao")
public class ResourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourseApplication.class, args);
    }

}
