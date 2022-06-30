package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("goods")
@Data
public class Goods {

    @TableId("good_id")
    private Integer goodId;
    private String goodName;
    private String goodType;
    private String goodSize;
    private Double goodValue;
}
