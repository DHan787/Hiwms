package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("low_warning")
@Data
public class LowWarning {
    @TableId("goods_id")
//    库存id
    private int goods_id;
//    最低库存量
    private int minNum;

}
