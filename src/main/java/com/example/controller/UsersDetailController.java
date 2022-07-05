package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.UsersDao;
import com.example.dao.UsersInfoDao;
import com.example.domain.Users;
import com.example.domain.UsersDetail;
import com.example.domain.UsersInfo;
import com.example.service.UsersDetailService;
import com.example.service.UsersInfoService;
import com.example.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.utils.idGenerator;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController//添加到IOC容器
@RequestMapping("/usersDetail")//设置路径
@CrossOrigin//解决跨域问题
public class UsersDetailController {

    @Autowired
    UsersDetailService usersDetailService;
    @Autowired
    private UsersInfoService usersInfoService;
    @Autowired
    private UsersController usersController;
    @Autowired

    private  UsersService usersService;

   @Autowired
   UsersDao usersDao;
    @Autowired
   UsersInfoDao usersInfoDao;


    @GetMapping//访问方式
    public List<UsersDetail> getAll() {

        List<Users> usersList =usersDao.selectList(null);

        List<UsersInfo> usersInfoList=usersInfoDao.selectList(null);
        //log.info("users获取的数据，{}",usersService.list());
        return this.setUsersDetail(usersList,usersInfoList);
    }

    /**
     * 装配用户详情
     */
    public List<UsersDetail> setUsersDetail(List<Users> usersList,List<UsersInfo> usersInfoList) {
         List<UsersDetail> usersDetailsList = new ArrayList<UsersDetail>();
        for (Users value : usersList) {
            System.out.println("id is :" + value.getUserId());
            for (UsersInfo info : usersInfoList) {
//                System.out.println("time is :" + info.getUsersInfoAltTime());
//                System.out.println("id:" + idGenerator.UserInfoIDGenerator((value.getUserId()), info.getUsersInfoAltTime()));
                if (idGenerator.UserInfoIDGenerator((value.getUserId()), info.getUserAltTime()) == info.getUsersInfoId()) {
                    UsersDetail usersDetail = new UsersDetail();
                    System.out.println(value.getUserName());
//                   System.out.println(info.getUsersInfoId());
//                   System.out.println("id:" + idGenerator.UserInfoIDGenerator((value.getUserId()), info.getUserAltTime()));
                    usersDetail.setUserId(value.getUserId());
                    usersDetail.setUserName(value.getUserName());
                    usersDetail.setUserLocation(info.getUserLocation());
                    usersDetail.setUserTele(info.getUserTele());
                    usersDetail.setUserRetailer(info.getUserRetailer());

                   // long timeMillis = System.currentTimeMillis();
                     usersDetail.setUsersInfoAltTime(info.getUserAltTime());

                    if (value.getUserRole() == 1) {
                        usersDetail.setUserRole("管理员");
                    } else {
                        usersDetail.setUserRole("用户");
                    }

                    usersDetailsList.add(usersDetail);
                }

            }
        }
//        System.out.println(usersDetail.toString());
        return usersDetailsList;
    }
    @GetMapping("/{id}")
    public List<UsersDetail> getById(@PathVariable int id){
        QueryWrapper<Object> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("userId",id);
        List<Users> usersList =usersDao.selectList(null);

        List<UsersInfo> usersInfoList=usersInfoDao.selectList(null);
        //log.info("users获取的数据，{}",usersService.list());
        return this.setUsersDetail(usersList,usersInfoList);
    }

}
