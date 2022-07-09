//package com.example.controller;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.util.UUID;
//
//@Controller
//@CrossOrigin
//
//public class PhotoController {
//
//    @Value("${SavePath.ProfilePhoto}")
//    private String ProfilePhotoSavePath;
//    @Value("${SavePath.ProfilePhotoMapper}")
//    private String ProfilePhotoMapperPath;
//
////    @RequestMapping("/pindex")
////    public String pindex(){
////        System.out.println(1);
////        return "pindex";
////    }
//
//
//    @PostMapping("/api/profilePhotoUpload")
//    public String profilePhotoUpload(@RequestParam("files") MultipartFile fileUpload, Model model){
////获取文件名
//        String fileName = fileUpload.getOriginalFilename();
////去掉文件名后缀
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
////避免文件覆盖，重命名文件
//        fileName = UUID.randomUUID()+suffixName;
//        try {
//
//            fileUpload.transferTo(new File(ProfilePhotoSavePath+fileName));
//            model.addAttribute("thps",(ProfilePhotoMapperPath+fileName)) ;
//            System.out.println(1);
//            return "/pindex";
//        } catch (Exception e){
//            System.out.println(2);
//            e.printStackTrace();
//            return "pindex";
//        }
//    }
//}
