package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.UsersInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author ginger
 */
@Mapper
@Component
public interface UsersInfoDao extends BaseMapper<UsersInfo> {
}
