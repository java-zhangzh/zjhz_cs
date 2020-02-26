package com.zjhz.gismap.config;



import com.zjhz.gismap.interceptor.PermissionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by 12947 on 2019/5/25.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {



    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionInterceptor());
    }


}
