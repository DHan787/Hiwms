package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Msgs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author ymm
 */
@Mapper
@Component
public interface MsgsDao extends BaseMapper<Msgs> {
    @Select("select * from msgs where type=#{type}")
    public List<Msgs> selectType(@Param("type") Integer tyep);

    @Update("update msgs set type=0  where msgs_id=#{msgid}")
    public  Integer updatamsg(@Param("msgid") Integer msgid);

}
