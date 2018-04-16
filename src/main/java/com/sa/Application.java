package com.sa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 * @Description:   主模块
 * @ClassName:     Application.java
 * @author         moe
 * @Date           2017-12-14
 */

@SpringBootApplication
@MapperScan("com.sa.modules.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
