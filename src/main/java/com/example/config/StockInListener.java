package com.example.config;

import cn.hutool.db.sql.Order;
import com.example.controller.OrdersController;
import com.example.controller.StockInController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StockInListener implements ApplicationListener<StockInEvent> {

    @Autowired
    OrdersController ordersController;
    @Override
    public void onApplicationEvent(StockInEvent event){
        Object source = event.getSource();
        System.out.println("监听到了……");
        /**
         * 监听到了就会触发此处，接收到消息
         */
        ordersController.saveMsg();
    }
}
