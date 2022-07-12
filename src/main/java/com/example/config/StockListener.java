package com.example.config;

import com.example.controller.OrdersController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author ymm
 * 监听配置类
 */
@Component
public class StockListener {

    @Autowired
    OrdersController ordersController;

    @EventListener
    public void stockInEvent(StockInEvent event){
        Object source = event.getSource();
        ordersController.saveInMsg();
    }

    @EventListener
    public void stockOutEvent(StockOutEvent event){
        Object source = event.getSource();
        ordersController.saveOutMsg();
    }

    @EventListener
    public void ordersBeginEvent(OrdersBeginEvent event){
        Object source = event.getSource();
        ordersController.saveOrdersMsg();
    }

    @EventListener
    public void applyOverEvent(ApplyOverEvent event){
        Object source = event.getSource();
        ordersController.saveApplyMsg();
    }



}
