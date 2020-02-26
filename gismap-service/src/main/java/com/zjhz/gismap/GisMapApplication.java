package com.zjhz.gismap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.zjhz.gismap","com.zjhz.base.model"})
@EnableEurekaClient
@EnableTransactionManagement
@MapperScan(value = "com.zjhz.gismap.dao")
@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class })
public class GisMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(GisMapApplication.class, args);
    }

}
