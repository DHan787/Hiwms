package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("warehouse")
@Data
public class Warehouse {

    @TableId("warehouse_id")
    private Integer warehouseId;
    private String warehouseName;
    private String warehouseType;
    private String warehouseSize;
    private Double warehouseValue;
    public Integer getwarehouseId() {
        return warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public String getWarehouseType() {
        return warehouseType;
    }
}
