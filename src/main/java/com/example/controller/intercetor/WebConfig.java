package com.example.controller.intercetor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new UserInterceptor()).excludePathPatterns("/")
                .excludePathPatterns("/users/login","static/**","/**/*.html","/**/**/*.html");
    }
}
