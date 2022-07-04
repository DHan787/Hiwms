package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Inventory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InventoryDao extends BaseMapper<Inventory> {
}
