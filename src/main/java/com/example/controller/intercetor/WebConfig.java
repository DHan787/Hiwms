package com.example.controller.intercetor;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/users/login"
                        , "/users/register",
                        "/pages/login.html"
                        , "/pages/register.html"
                        , "/assets/**");
    }
}
