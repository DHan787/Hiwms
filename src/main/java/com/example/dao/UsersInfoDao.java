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
    /**
     * 初始化用户信息
     * @param infoId id
     * @param time time
     * @param role 角色
     * @return 数量
     */
    @Insert("INSERT into users_info (users_Info_id,user_alt_time,user_info_role) values (#{infoId},#{time},#{role})")
    public int init(@Param("infoId") Long infoId, @Param("time") Long time,@Param("role") String role);
}
