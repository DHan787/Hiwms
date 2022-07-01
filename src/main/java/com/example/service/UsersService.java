package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Users;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UsersService extends IService<Users> {
}
