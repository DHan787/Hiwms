package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Goods;
import com.example.domain.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author ginger
 */
@Mapper
@Component
public interface OrdersDao extends BaseMapper<Orders> {
    /**
     * 模糊查询
     * @param ordersId id
     * @return list
     */
    @Select("select * from orders where order_id like #{ordersId}")
    List<Orders> selectOrdersId(@Param("ordersId") String ordersId);

    /**
     * 模糊查询
     * @return 数字
     */
    @Select("select count(*) from orders")
    int selectCount();
}
