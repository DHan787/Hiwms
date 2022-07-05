package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface GoodsDao extends BaseMapper<Goods> {
    //模糊查询
    @Select("select * from goods where goods_name like #{goodsName}")
     List<Goods> selectPagesLike(@Param("goodsName") String goodsName);

    //查询有多少数据
    @Select("select count(*) from goods")
    int selectCount();
}
