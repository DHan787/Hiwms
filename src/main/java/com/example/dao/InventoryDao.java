package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Goods;
import com.example.domain.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface InventoryDao extends BaseMapper<Inventory> {
    //模糊查询
    @Select("select * from inventory where inventory_id like #{inventoryId} and goods_name like #{goodsName}")
    List<Inventory> selectInventory(@Param("inventoryId") String inventoryId,@Param("goodsName") String goodsName);

    //查询有多少数据
    @Select("select count(*) from inventory")
    int selectCount();
}
