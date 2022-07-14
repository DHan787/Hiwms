package com.example.config;

import com.example.domain.Orders;
import org.springframework.context.ApplicationEvent;

/**
 * @author ymm
 * 申请完成事件
 */
public class ApplyOverEvent extends ApplicationEvent {
    /**
     * 申请是否完成
     */
    private Orders applyOver;
    /**
     * 内容
     */
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


    public ApplyOverEvent(Object source, Orders applyOver, String content, Integer orderId){
        super(source);
        this.applyOver = applyOver;
        this.content = content;
        this.orderId = orderId;
    }

    public ApplyOverEvent(Object source) {
        super(source);
    }

}
