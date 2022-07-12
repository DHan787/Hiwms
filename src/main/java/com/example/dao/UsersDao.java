package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ginger
 */
@Mapper
@Component
public interface UsersDao extends BaseMapper<Users> {
    /**
     *模糊查询
     * @param userId id
     * @param userName name
     * @return list
     */
    @Select("select * from users where userId like #{userId} and user_name like #{userName}")
    List<Users> selectUsers(@Param("userId") String userId, @Param("userName") String userName);

    /**
     * 根据名字模糊查询
     * @param userName name
     * @return user
     */
    @Select("select * from users where user_name like #{userName}")
    Users selectUserByName(@Param("userName") String userName);

    /**
     *  查询有多少数据
     */
    @Select("select count(*) from users")
    int selectCount();

}
