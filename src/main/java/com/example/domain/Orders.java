package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ginger
 */
@TableName("orders")
@Data
public class Orders {
    @TableId("order_id")
    /**
     * 订单ID
     */
    private Integer orderId;
    /**
     *订单种类 1 入库 2 出库
     */
    private Integer orderType;
    /**
     *订单开始时间
     */
    private String orderStartTime;
    /**
     *订单结束时间
     */
    private String orderEndTime;
    /**
     *订单状态 待入库10，入库中11，已入库12，待出库20，出库中21，运输中22，出库完成23
     */
    private Integer orderStatus;
    /**
     *订单发起人ID
     */
    private Integer orderInit;
    /**
     *订单操作员ID
     */
    private Integer orderOperator;

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getOrderInit() {
        return orderInit;
    }
}
