package com.example.controller;

import com.example.domain.Users;
import com.example.domain.UsersInfo;
import com.example.service.UsersInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController//添加到IOC容器
@RequestMapping("/usersInfo")//设置路径
@CrossOrigin//解决跨域问题
public class UsersInfoController {
    @Autowired
    private UsersInfoService usersInfoService;



    @GetMapping//访问方式
    public List<UsersInfo> getAll() {
        System.out.println(usersInfoService.list());
        return usersInfoService.list();
    }

    public UsersInfo getById(@PathVariable long id) {
        //System.out.println("getbyid");
        return usersInfoService.getById(id);
    }

}
