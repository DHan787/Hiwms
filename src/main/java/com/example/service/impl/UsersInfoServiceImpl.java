package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.UsersInfoDao;
import com.example.domain.Users;
import com.example.domain.UsersDetail;
import com.example.domain.UsersInfo;
import com.example.service.UsersInfoService;
import com.example.utils.idGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ginger
 */
@Service
public class UsersInfoServiceImpl extends ServiceImpl<UsersInfoDao, UsersInfo> implements UsersInfoService {

}
