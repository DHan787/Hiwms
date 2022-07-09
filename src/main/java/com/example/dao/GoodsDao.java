package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ginger
 */
@Component
@Mapper
public interface GoodsDao extends BaseMapper<Goods> {


    /**
     * 模糊查询
     * @param goodsName name
     * @return list
     */
    @Select("select * from goods where goods_name like #{goodsName}")
     List<Goods> selectGoodsName(@Param("goodsName") String goodsName);

    /**
     * find the number of the data
     * @return 1
     */
    @Select("select count(*) from goods")
    int selectCount();
}
