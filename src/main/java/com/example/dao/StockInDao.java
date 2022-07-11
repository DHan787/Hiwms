package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.StockIn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author ginger
 */
@Mapper
@Component
public interface StockInDao extends BaseMapper<StockIn>{
}
