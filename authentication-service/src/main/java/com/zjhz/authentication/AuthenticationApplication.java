package com.zjhz.authentication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication(scanBasePackages = {"com.zjhz.authentication", "com.zjhz.base.model"})
@EnableEurekaClient
@MapperScan(value = "com.zjhz.authentication.dao")
public class AuthenticationApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AuthenticationApplication.class);
    }


}

