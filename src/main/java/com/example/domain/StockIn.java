package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("stockin")
@Data
public class StockIn {
    @TableId("stock_id")
//    库存id
    private Integer stockId;
//    货品名称
    private String goodsName;
//    货品数量
    private Integer goodsNumber;
//    所属订单id
    private Integer orderId;
}
