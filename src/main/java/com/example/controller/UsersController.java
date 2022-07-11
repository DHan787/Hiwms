package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.UsersDao;
import com.example.domain.*;
import com.example.service.UsersDetailService;
import com.example.service.UsersInfoService;
import com.example.service.UsersService;
import com.example.utils.idGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.utils.EncryptUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private UsersDao usersDao;

    /**
     * 获得用户表
     *
     * @return usersService.list()
     */
    @GetMapping//访问方式
    public List<Users> getAll() {
        //log.info("users获取的数据，{}",usersService.list());
        //System.out.println(usersService.list());
        return usersService.list();
    }

    /**
     * 更新用户表
     *
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
     *
     * @param users
     * @return 0 登录失败
     * 1 登录为管理员
     * 2 登录为货物员
     * 3 登录为操作员
     */
    @PostMapping("/login")
    private Integer login(@RequestBody Users users, HttpServletRequest request) throws Exception {
//        System.out.println(users.getUserName() + users.getUserPassword());
        List<Users> usersList = usersService.list();
//        System.out.println("database:" + usersList);
        for (Users value : usersList) {
            if (value.getUserName().equals(users.getUserName())) {
                if (value.getUserPassword().equals(EncryptUtil.shaEncode(users.getUserPassword()))) {
//                    System.out.println("role is:" + value.getUserRole());
                    request.getSession().setAttribute("users", value);
                    System.out.println("set:" + request.getSession().getAttribute("users"));
                    return value.getUserRole();
                }
            }
        }
        return 0;
    }

    /**
     * 登出
     * @param request
     * @return login地址
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "user/login.html";
    }

    /**
     * 保存用户
     *
     * @param users
     * @return if success
     */
    @PostMapping("/save")
    public boolean saveUsers(@RequestBody Users users) {
        try {
            users.setUserPassword(EncryptUtil.shaEncode(users.getUserPassword()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersService.save(users);
    }


    /**
     * 删除用户
     *
     * @param id
     * @return usersService.removeById(id)
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        System.out.println("the id is :" + id);

        //usersInfoService.removeById(id);  //有bug，记得改 前端要传alttime，这里再生成infoId，再删除
        return usersService.removeById(id);
    }

    /**
     * 注册
     *
     * @param users
     * @return if success
     */
    @PostMapping("/register")
    public boolean register(@RequestBody Users users) {
        try {
            users.setUserPassword(EncryptUtil.shaEncode(users.getUserPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersService.save(users);
    }

    /**
     * 更新用户
     *
     * @param users
     * @return if success
     */
    @PutMapping
    public boolean updateUsers(@RequestBody Users users) {
        System.out.println(users.getUserName());
        return usersService.updateById(users);
    }

    /**
     * 根据用户类型获取订单 1-管理员 2-货物员 3-操作员
     *
     * @param userRole
     * @return users
     */
    @GetMapping("/getByRole")
    public List<Users> getByRole(@RequestParam Integer userRole) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("user_role", userRole);
        List<Users> users = usersDao.selectList(wrapper);
        return users;
    }
}
