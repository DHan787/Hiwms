package com.example.config;

import com.example.domain.StockOut;
import org.springframework.context.ApplicationEvent;

/**
 * @author ymm
 * 出库申请事件
 */
public class StockOutEvent extends ApplicationEvent {
    private StockOut stockOut;

    private  String content;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    private Integer orderId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public StockOutEvent(Object source, StockOut stockOut, String content, Integer orderId){
        super(source);
        this.stockOut = stockOut;
        this.content = content;
        this.orderId = orderId;
    }

    public StockOutEvent(Object source) {
        super(source);
    }

}
