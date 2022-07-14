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
    /**
     *仓库id
     */
    private Integer warehouseId;
    /**
     *仓库名称
     */
    private String warehouseName;
    /**
     * 仓库地址
     */
    private String warehouseLocation;
    /**
     * 仓库类型
     */
    private String warehouseType;
    /**
     *仓库大小
     */
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
