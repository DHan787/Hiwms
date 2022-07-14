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

    /**
     * 入库事件监听
     * @param event 事件
     */
    @EventListener
    public void stockInEvent(StockInEvent event){
        Object source = event.getSource();
        Integer id = event.getOrderId();
        msgsController.saveInMsg(id);
    }
    /**
     * 出库事件监听
     * @param event 事件
     */
    @EventListener
    public void stockOutEvent(StockOutEvent event){
        Object source = event.getSource();
        Integer id = event.getOrderId();
        msgsController.saveOutMsg(id);
    }

    /**
     * 订单开始事件监听
     * @param event 事件
     */
    @EventListener
    public void ordersBeginEvent(OrdersBeginEvent event){
        Object source = event.getSource();
        Integer id = event.getOrderId();
        msgsController.saveOrdersMsg(id);
    }
    /**
     * 订单结束事件监听
     * @param event 事件
     */
    @EventListener
    public void applyOverEvent(ApplyOverEvent event){
        Object source = event.getSource();
        Integer id = event.getOrderId();
        msgsController.saveApplyMsg(id);
    }

}
