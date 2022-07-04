package com.example.controller;

import com.example.domain.Users;
import com.example.domain.UsersDetail;
import com.example.domain.UsersInfo;
import com.example.service.UsersDetailService;
import com.example.service.UsersInfoService;
import com.example.service.UsersService;
import com.example.utils.idGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.utils.EncryptUtil;

import java.util.List;

@Slf4j
@RestController//添加到IOC容器
@RequestMapping("/users")//设置路径
@CrossOrigin//解决跨域问题
public class UsersController {
    @Autowired//
    private UsersService usersService;

    @Autowired
    private UsersInfoService usersInfoService;


    /**
     * 获得用户表
     * @return usersService.list()
     */
    @GetMapping//访问方式
    public List<Users> getAll() {
        //log.info("users获取的数据，{}",usersService.list());
        return usersService.list();
    }

    /**
     * 更新用户表
     * @param users
     * @return usersService.updateById(users)
     */
    public boolean update(@RequestBody Users users) {
        return usersService.updateById(users);
    }

    @GetMapping("/{id}")
    public Users getById(@PathVariable int id) {
        //System.out.println("getbyid");
        return usersService.getById(id);
    }

    /**
     * 登录
     * @param users
     * @return 0 登录失败
     *          1 登录为管理员
     *          2 登录为货物员
     *          3 登录为操作员
     */
    @PostMapping("/login")
    private Integer login(@RequestBody Users users) throws Exception {
//        System.out.println(users.getUserName() + users.getUserPassword());
        List<Users> usersList = usersService.list();
//        System.out.println("database:" + usersList);
        for (Users value : usersList) {
            if (value.getUserName().equals(users.getUserName()))
                if (value.getUserPassword().equals(EncryptUtil.shaEncode(users.getUserPassword()))) {
//                    System.out.println("role is:" + value.getUserRole());
                    return value.getUserRole();
                }
        }
        return 0;
    }

    /**
     * 保存用户
     * @param users
     * @return
     */
    @PostMapping("/save")
    public boolean saveUsers(@RequestBody Users users){
        try {
            users.setUserPassword(EncryptUtil.shaEncode(users.getUserPassword()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersService.save(users);
    }


    /**
     * 删除用户
     * @param id
     * @return usersService.removeById(id)
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        System.out.println("the id is :"+id);
        usersInfoService.removeById(id);
        return usersService.removeById(id);
    }

    @PostMapping("/register")
    public boolean register(@RequestBody Users users){
        try {
            users.setUserPassword(EncryptUtil.shaEncode(users.getUserPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersService.save(users);
    }

    @PutMapping
    public boolean updateUsers(@RequestBody Users users){
        System.out.println(users.getUserName());
        return usersService.updateById(users);
    }

}
