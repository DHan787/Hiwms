package com.example.controller;

import com.example.domain.Users;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//添加到IOC容器
@RequestMapping("/users")//设置路径
@CrossOrigin//解决跨域问题
public class UsersController {
    @Autowired//
    private UsersService usersService;

    @GetMapping//访问方式
    public List<Users> getAll() {
        return usersService.list();
    }

    public boolean update(@RequestBody Users users) {
        return usersService.updateById(users);
    }

    @GetMapping("/{id}")
    public Users getById(@PathVariable int id) {
        return usersService.getById(id);

    }

    private boolean loginVerify(String name, String password) {
        return true;
    }

    @RequestMapping("/loginTest")
    public boolean userLogin(@RequestBody Users users) {
        return loginVerify(users.getUserName(), users.getUserPassword());
    }
}
