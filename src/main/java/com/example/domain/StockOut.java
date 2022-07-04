package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("stockout")
@Data
public class StockOut {
    @TableId("stock_id")
//    库存id
    private Integer stockId;
//    库存名称
    private String goodsName;
//    库存数量
    private Integer goodsNumber;
//    所属订单id
    private Integer orderId;
}
