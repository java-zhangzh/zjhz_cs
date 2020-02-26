package com.zjhz.authentication.config;

/**
 * <b>功能名：</b>SwaggerConfig<br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2019 ZJHZ  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019-06-06 zhangzhonghao
 */

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

 /*   @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    }*/

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("验证授权服务接口 Swagger API")
                .description("验证授权服务接口")
                .termsOfServiceUrl("")
                .contact(new Contact("java技术","url","test@zzh.com"))
                .version("2.0")
                .build();
    }



}