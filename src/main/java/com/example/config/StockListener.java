package com.example.config;

import com.example.controller.MsgsController;
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
    MsgsController msgsController;

    @EventListener
    public void stockInEvent(StockInEvent event){
        Object source = event.getSource();
        Integer id = event.getOrderId();
        msgsController.saveInMsg(id);
    }

    @EventListener
    public void stockOutEvent(StockOutEvent event){
        Object source = event.getSource();
        Integer id = event.getOrderId();
        msgsController.saveOutMsg(id);
    }

    @EventListener
    public void ordersBeginEvent(OrdersBeginEvent event){
        Object source = event.getSource();
        Integer id = event.getOrderId();
        msgsController.saveOrdersMsg(id);
    }

    @EventListener
    public void applyOverEvent(ApplyOverEvent event){
        Object source = event.getSource();
        Integer id = event.getOrderId();
        msgsController.saveApplyMsg(id);
    }



}
