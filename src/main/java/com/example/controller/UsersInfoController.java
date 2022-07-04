package com.example.controller;

import com.example.domain.Users;
import com.example.domain.UsersInfo;
import com.example.service.UsersInfoService;
import com.example.utils.EncryptUtil;
import com.example.utils.idGenerator;
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


    /**
     * 获取所有用户信息
     * @return
     */
    @GetMapping//访问方式
    public List<UsersInfo> getAll() {
        System.out.println(usersInfoService.list());
        return usersInfoService.list();
    }

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public UsersInfo getById(@PathVariable long id) {
        //System.out.println("getbyid");
        return usersInfoService.getById(id);
    }


    /**
     * 保存用户信息
     * @param usersInfo
     * @return
     */
    @PostMapping("/save")
    public boolean saveUsersInfo(@RequestBody UsersInfo usersInfo, @RequestParam Integer userId){
        try {

            long timeMillis = System.currentTimeMillis();
            usersInfo.setUsersInfoAltTime(timeMillis);
            usersInfo.setUsersInfoId(idGenerator.UserInfoIDGenerator(userId, usersInfo.getUsersInfoAltTime()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersInfoService.save(usersInfo);
    }

    /**
     * 更新用户信息
     * @param usersInfo
     * @return
     */
    @PutMapping
    public boolean updateUsersInfo(@RequestBody UsersInfo usersInfo, @RequestParam Integer userId, @RequestParam Long usersInfoAltTime){

        log.info(usersInfo.toString());
        /*long timeMillis = System.currentTimeMillis();
        usersInfo.setUsersInfoAltTime(timeMillis);*/
        log.info("UsersInfoAltTime1,{}",usersInfoAltTime);
        log.info("userId1,{}",userId);
        usersInfo.setUsersInfoAltTime(usersInfoAltTime);
        usersInfo.setUsersInfoId(idGenerator.UserInfoIDGenerator(userId, usersInfo.getUsersInfoAltTime()));
        log.info("userInfoId1,{}",usersInfo.getUsersInfoId());
        boolean result =  usersInfoService.updateById(usersInfo);
        //log.info("userInfoLocation,{}",usersInfo.getUsersInfoLocation());
        long timeMillis = System.currentTimeMillis();
        usersInfo.setUsersInfoAltTime(timeMillis);
        log.info("UsersInfoAltTime2,{}",usersInfo.getUsersInfoAltTime());
        usersInfo.setUsersInfoId(idGenerator.UserInfoIDGenerator(userId, usersInfo.getUsersInfoAltTime()));
        log.info("userInfoId2,{}",usersInfo.getUsersInfoId());
        return result;
    }

}
