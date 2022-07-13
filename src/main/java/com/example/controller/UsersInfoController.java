package com.example.controller;

import com.example.domain.Users;
import com.example.domain.UsersInfo;
import com.example.service.UsersInfoService;
import com.example.service.UsersService;
import com.example.utils.EncryptUtil;
import com.example.utils.idGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author ginger
 */
@Slf4j
//添加到IOC容器
@RestController
//设置路径
@RequestMapping("/usersInfo")
//解决跨域问题
@CrossOrigin

public class UsersInfoController {
    @Autowired
    private UsersInfoService usersInfoService;


    /**
     * 获取所有用户信息
     *
     * @return list
     */
    @GetMapping
    public List<UsersInfo> getAll() {
        System.out.println(usersInfoService.list());
        return usersInfoService.list();
    }

    /**
     * 根据id获取用户信息
     *
     * @param id id
     * @return info
     */
    @GetMapping("/{id}")
    public UsersInfo getById(@PathVariable long id) {
        return usersInfoService.getById(id);
    }


    /**
     * save user info
     * @param usersInfo info
     * @param userId id
     * @return if success
     */
    @PostMapping("/save")
    public boolean saveUsersInfo(@RequestBody UsersInfo usersInfo, @RequestParam Integer userId) {
        try {

            long timeMillis = System.currentTimeMillis();
            usersInfo.setUserAltTime(timeMillis);
            usersInfo.setUsersInfoId(idGenerator.UserInfoIDGenerator(userId, usersInfo.getUserAltTime()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersInfoService.save(usersInfo);
    }

    /**
     * 更新用户信息
     *
     * @param usersInfo info
     * @return if success
     */
    @PutMapping
    public boolean updateUsersInfo(@RequestParam Integer userId, @RequestParam Long usersInfoAltTime, @RequestBody UsersInfo usersInfo) {
        //得到UserInfoId
        usersInfo.setUserAltTime(usersInfoAltTime);
        usersInfo.setUsersInfoId(idGenerator.UserInfoIDGenerator(userId, usersInfo.getUserAltTime()));

        return usersInfoService.updateById(usersInfo);
    }

    /**
     * 删除用户信息
     *
     * @param userId id
     * @return if success
     */
    @DeleteMapping()
    public boolean deleteUserInfo(@RequestParam Integer userId) {

        long id = userId;
        List<UsersInfo> usersInfoList = usersInfoService.list();
        for (UsersInfo value : usersInfoList
        ) {
            if (value.getUsersInfoId() == idGenerator.UserInfoIDGenerator(userId, value.getUserAltTime())) {
                id = value.getUsersInfoId();
            }
        }
        return usersInfoService.removeById(id);
    }


    /**
     * @param userId    id
     * @param
     * @return if success
     */
    @PostMapping("/init")
    public boolean intiUserInfo(@RequestParam Integer userId) {
        long timeMills = System.currentTimeMillis();
        UsersInfo usersInfo = new UsersInfo();
        usersInfo.setUserAltTime(timeMills);
        usersInfo.setUsersInfoId(idGenerator.UserInfoIDGenerator(userId, usersInfo.getUserAltTime()));
        return usersInfoService.save(usersInfo);
    }

    /**
     * 获取个人信息
     * @param request re
     * @return UsersInfo
     */
    @GetMapping("/getPersonalInfo")
    public UsersInfo getPersonalInfo(HttpServletRequest request){
        Object id = request.getSession().getAttribute("users");
        UsersInfo usersInfo;
        int userId = Integer.parseInt(id.toString());
        Long infoId = null;
        List<UsersInfo> usersInfoList = this.getAll();
        for (UsersInfo value: usersInfoList
             ) {
            if(value.getUserAltTime() == idGenerator.UserInfoIDGenerator(userId,value.getUserAltTime())){
                infoId = value.getUsersInfoId();
                return this.usersInfoService.getById(infoId);
            }
        }
        return null;
    }

    /**
     * save user info
     * @param usersInfo info
     * @return if success
     */
    @PostMapping("/saveInfo")
    public boolean saveUsersInfo(@RequestBody UsersInfo usersInfo,HttpServletRequest request) {
        Object id = request.getSession().getAttribute("users");
        int userId  = Integer.parseInt(id.toString());
        try {
            long timeMillis = System.currentTimeMillis();
            usersInfo.setUserAltTime(timeMillis);
            usersInfo.setUsersInfoId(idGenerator.UserInfoIDGenerator(userId, usersInfo.getUserAltTime()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersInfoService.save(usersInfo);
    }

    /**
     * 更新个人信息
     * @param usersInfoAltTime alt time
     * @param usersInfo info 实体
     * @param request null
     * @return if success
     */
    @PutMapping("/updateInfo")
    public boolean updateUsersInfo( @RequestParam Long usersInfoAltTime, @RequestBody UsersInfo usersInfo,HttpServletRequest request) {
        Object id = request.getSession().getAttribute("users");
        int userId  = Integer.parseInt(id.toString());
        //得到UserInfoId
        usersInfo.setUserAltTime(usersInfoAltTime);
        usersInfo.setUsersInfoId(idGenerator.UserInfoIDGenerator(userId, usersInfo.getUserAltTime()));

        return usersInfoService.updateById(usersInfo);
    }

}
