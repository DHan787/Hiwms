package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("goods")
@Data
public class Goods {

    @TableId("goodId")
    private Integer goodId;

    private String goodName;

    private String goodType;

    private String goodSize;

    private Double goodValue;
}
