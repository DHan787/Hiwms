//package com.example.utils;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class PhotoConfigure implements WebMvcConfigurer {
//
//    @Value("${SavePath.ProfilePhoto}")
//    private String ProfilePhotoPath;
//    @Value("${SavePath.ProfilePhotoMapper}")
//    private String ProfilePhotoMapperPath;
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler( ProfilePhotoMapperPath+"**").addResourceLocations("file:"+ProfilePhotoPath);
//    }
//}
