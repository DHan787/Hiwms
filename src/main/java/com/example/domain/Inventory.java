package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("inventory")
@Data
public class Inventory {
    @TableId("inventory_id")
    private Integer inventoryId;
    private String goodsName;
    private Integer goodsNumber;
    private String warehouseName;


    public Integer getInventoryId() {
        return inventoryId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public String getWarehouseName() {
        return warehouseName;
    }


    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }
}

