package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.UsersInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ginger
 */
@Transactional
public interface UsersInfoService extends IService<UsersInfo> {
}
