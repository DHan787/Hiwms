package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.UsersInfoDao;
import com.example.domain.UsersInfo;
import com.example.service.UsersInfoService;
import org.springframework.stereotype.Service;

@Service
public class UsersInfoServiceImpl extends ServiceImpl<UsersInfoDao, UsersInfo> implements UsersInfoService {
}
