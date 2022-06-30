package com.example.controller;

import com.example.domain.Users;
import com.example.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController//添加到IOC容器
@RequestMapping("/users")//设置路径
@CrossOrigin//解决跨域问题
public class UsersController {
    @Autowired//
    private UsersService usersService;

    @GetMapping//访问方式
    public List<Users> getAll() {
        //log.info("users获取的数据，{}",usersService.list());
        return usersService.list();
    }

    public boolean update(@RequestBody Users users) {
        return usersService.updateById(users);
    }

    @GetMapping("/{id}")
    public Users getById(@PathVariable int id) {
        //System.out.println("getbyid");
        return usersService.getById(id);
    }
    /*
        验证登录
    */
    @PostMapping
    private boolean login(@RequestBody Users users) {
        System.out.println(users.getUserName() + users.getUserPassword());
        List<Users> usersList = usersService.list();
        System.out.println("database:" + usersList);
        for (Users value : usersList) {
           System.out.println("name：" + value.getUserName());
            if (value.getUserName().equals(users.getUserName()))
                if (value.getUserPassword().equals(users.getUserPassword()))
                    return true;
        }
        return false;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return usersService.removeById(id);
    }

}
