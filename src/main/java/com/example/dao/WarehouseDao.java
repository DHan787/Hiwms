package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Goods;
import com.example.domain.Warehouse;
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
public interface WarehouseDao extends BaseMapper<Warehouse> {
    /**
     * 模糊查询
     * @param warehouseName name
     * @return list
     */
    @Select("select * from warehouse where warehouse_name like #{warehouseName}")
    List<Warehouse> selectWarehouseName(@Param("warehouseName") String warehouseName);

    /**
     * 查询有多少数据
     * @return int
     */
    @Select("select count(*) from warehouse")
    int selectCount();
}
