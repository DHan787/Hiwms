package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * @author ginger
 */
@TableName("warehouse")
@Data
public class Warehouse {

    @TableId("warehouse_id")
    private Integer warehouseId;
    private String warehouseName;
    private String warehouseLocation;
    private String warehouseType;
    private Integer warehouseSize;
    public Integer getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseID(Integer warehouseId){
        this.warehouseId=warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public String getWarehouseType() {
        return warehouseType;
    }
}
