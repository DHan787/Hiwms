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
import com.example.utils.idGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ginger
 */
@Slf4j
//添加到IOC容器
@RestController
//设置路径
@RequestMapping("/usersDetail")
//解决跨域问题
@CrossOrigin

public class UsersDetailController {

    @Autowired
    UsersDetailService usersDetailService;
    @Autowired
    private UsersInfoService usersInfoService;
    @Autowired
    private UsersController usersController;
    @Autowired

    private UsersService usersService;

    @Autowired
    UsersDao usersDao;
    @Autowired
    UsersInfoDao usersInfoDao;
    private final static Integer ADMIN_ROLE_NUMBER = 1;
    private final static Integer OPERATOR_ROLE_NUMBER = 2;
    private final static Integer MARKET_ROLE_NUMBER = 3;


    /**
     * getAll
     *
     * @return if sccuess
     */
    @GetMapping
    public List<UsersDetail> getAll() {

        List<Users> usersList = usersDao.selectList(null);

        List<UsersInfo> usersInfoList = usersInfoDao.selectList(null);
        return this.setUsersDetail(usersList, usersInfoList);
    }


    /**
     * 装配用户详情
     *
     * @param usersList     用户表
     * @param usersInfoList 用户信息表
     * @return detail
     */
    public List<UsersDetail> setUsersDetail(List<Users> usersList, List<UsersInfo> usersInfoList) {
        List<UsersDetail> usersDetailsList = new ArrayList<>();
        for (Users value : usersList) {
            System.out.println("id is :" + value.getUserId());
            for (UsersInfo info : usersInfoList) {
                if (idGenerator.UserInfoIDGenerator((value.getUserId()), info.getUserAltTime()) == info.getUsersInfoId()) {
                    UsersDetail usersDetail = new UsersDetail();
                    System.out.println(value.getUserName());
                    usersDetail.setUserId(value.getUserId());
                    usersDetail.setUserName(value.getUserName());
                    usersDetail.setUserLocation(info.getUserLocation());
                    usersDetail.setUserTele(info.getUserTele());
                    usersDetail.setUserRetailer(info.getUserRetailer());
                    usersDetail.setUsersInfoAltTime(info.getUserAltTime());
                    if (value.getUserRole().equals(ADMIN_ROLE_NUMBER)) {
                        usersDetail.setUserRole("管理员");
                    } else if(value.getUserRole().equals(OPERATOR_ROLE_NUMBER)){
                        usersDetail.setUserRole("操作员");
                    }else if(value.getUserRole().equals(MARKET_ROLE_NUMBER)){
                        usersDetail.setUserRole("货物员");
                    }else{
                        usersDetail.setUserRole("临时用户");
                    }
                    usersDetailsList.add(usersDetail);
                }
            }
        }
        return usersDetailsList;
    }

    /**
     * @param id id
     * @return if success
     */
    @GetMapping("/{id}")
    public List<UsersDetail> getById(@PathVariable int id) {
        System.out.println("getDetail");
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", id);
        List<Users> usersList = usersDao.selectList(queryWrapper);
        List<UsersInfo> usersInfoList = usersInfoDao.selectList(null);
        return this.setUsersDetail(usersList, usersInfoList);
    }

    /**
     * 模糊查询
     *
     * @param userId   id
     * @param userName name
     * @return usersDetail
     */
    @GetMapping("/like")
    public List<UsersDetail> getByIds(@RequestParam String userId, @RequestParam String userName) {
        List<Users> usersList = usersDao.selectUsers("%" + userId + "%", "%" + userName + "%");
        List<UsersInfo> usersInfoList = usersInfoDao.selectList(null);
        return this.setUsersDetail(usersList, usersInfoList);
    }

    /**
     * 根据session 获取个人信息
     *
     * @param request re
     * @return detail
     */
    @GetMapping("/getDetail")
    public List<UsersDetail> getDetail(HttpServletRequest request) {
        Object id = request.getSession().getAttribute("users");
        return this.getById(Integer.parseInt(id.toString()));
    }
}
