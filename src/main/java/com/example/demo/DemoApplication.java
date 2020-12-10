package com.example.demo;

import com.zhangaochong.spring.starter.openapi.annotation.EnableOpenApiAuth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@EnableOpenApiAuth
@SpringBootApplication
// @ServletComponentScan(basePackages = "com.example.demo")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
