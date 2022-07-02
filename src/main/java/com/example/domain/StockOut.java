package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("stockout")
@Data
public class StockOut {
    @TableId("stock_id")
    private Integer stockId;
    private String goodsName;
    private Integer goodsNumber;
    private Integer warehouseId;
    private Integer shelfId;
    private String stockStatus;

}
