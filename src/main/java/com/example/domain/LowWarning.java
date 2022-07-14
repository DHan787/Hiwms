package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ginger
 */
@TableName("low_warning")
@Data
public class LowWarning {
    @TableId("goods_id")
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     *最小库存数量
     */
    private Integer minNum;

}
