package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.UsersInfo;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UsersInfoService extends IService<UsersInfo> {
}
