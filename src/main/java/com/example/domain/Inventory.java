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
    private String goodsNumber;
    private String warehouseName;
    private String warehouseLocation;

    public Integer getInventoryId() {
        return inventoryId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }
}

