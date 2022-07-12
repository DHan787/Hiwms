package com.example.config;

import com.example.domain.Orders;
import org.springframework.context.ApplicationEvent;

/**
 * @author ymm
 * 订单开始事件
 */

public class OrdersBeginEvent extends ApplicationEvent {
    private Orders orders;

    private  String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public OrdersBeginEvent(Object source, Orders orders, String content){
        super(source);
        this.orders = orders;
        this.content = content;
    }

    public OrdersBeginEvent(Object source) {
        super(source);
    }

}
