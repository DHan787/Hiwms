package com.example.config;

import cn.hutool.db.sql.Order;
import com.example.domain.StockIn;
import org.springframework.context.ApplicationEvent;

/**
 * @author ymm
 * 入库申请事件
 */
public class StockInEvent extends ApplicationEvent {
    /**
     * 入库对象
     */
    private StockIn stockIn;
    /**
     * 内容
     */
    private  String content;
    /**
     * 订单ID
     */
    private Integer orderId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getOrderId(){
        return orderId;
    }

    public void setOrderId(Integer orderId){
        this.orderId = orderId;
    }

    public StockInEvent(Object source, StockIn stockIn, String content, Integer orderId){
        super(source);
        this.stockIn = stockIn;
        this.content = content;
        this.orderId = orderId;
    }

    public StockInEvent(Object source) {
        super(source);
    }

}
