package com.example.controller.intercetor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/users/login"
                        ,"/static/assets/pages/login.html"
                        ,"/users/register"
                        ,"/static/assets/pages/register.html"
                        ,"/static/assets/css/*"
                        ,"/static/assets/js/*");
    }
}
