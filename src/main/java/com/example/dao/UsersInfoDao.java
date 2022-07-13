package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.UsersInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author ginger
 */
@Mapper
@Component
public interface UsersInfoDao extends BaseMapper<UsersInfo> {
    @Insert("INSERT into users_info (users_Info_id,user_alt_time) values (#{infoId},#{time})")
    public int init(@Param("infoId") Long infoId, @Param("time") Long time);
}
