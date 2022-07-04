package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("goods")
@Data
public class Goods {

    @TableId("goods_id")
    private Integer goodsId;
    private String goodsName;
    private String goodsType;
    private Integer goodsNumber;
    private String goodsSize;
    private Double goodsValue;

}
