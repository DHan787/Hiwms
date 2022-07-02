package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.UsersDetail;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UsersDetailService extends IService<UsersDetail> {
}
