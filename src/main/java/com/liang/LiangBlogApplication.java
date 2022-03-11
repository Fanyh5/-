package com.liang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.liang.mapper")
@EnableScheduling //开启基于注解的定时任务
public class LiangBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiangBlogApplication.class, args);
    }

}
