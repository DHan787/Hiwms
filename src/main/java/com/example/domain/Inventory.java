package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("inventory")
@Data
public class Inventory {
    @TableId("inventory_id")
    private Integer inventoryId;
    private String goodName;
    private String goodNumber;
    private String warehouseName;
    private String warehouseLocation;

    public Integer getInventoryId() {
        return inventoryId;
    }

    public String getGoodName() {
        return goodName;
    }

    public String getGoodNumber() {
        return goodNumber;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setGoodNumber(String goodNumber) {
        this.goodNumber = goodNumber;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
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

