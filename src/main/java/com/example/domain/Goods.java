package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author ginger
 */
@TableName("goods")
@Data
@ToString
public class Goods {

    @TableId("goods_id")

    /**
     * 商品名称
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品类型
     */
    private String goodsType;
    /**
     * 商品尺寸
     */
    private String goodsSize;
    /**
     * 商品价值
     */
    private String goodsValue;
    /**
     * 商品数量
     */
    private Integer goodsNumber;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }


    public String getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize;
    }

    public String getGoodsValue() {
        return goodsValue;
    }

    public void setGoodsValue(String goodsValue) {
        this.goodsValue = goodsValue;
    }
}
