/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@MapperScan(basePackages = "com.hebin.edu.lesson.dao")
@RefreshScope
@EnableDiscoveryClient
public class LessonApplication {

    public static void main(String[] args) {
        SpringApplication.run(LessonApplication.class, args);
    }

}
