package com.example.controller;


import com.example.domain.Orders;
import com.example.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 获取订单表
     * @return
     */
    @GetMapping//访问方式
    public List<Orders> getAll() {
        //System.out.println(ordersService.list());
        //System.out.println("used");
        return ordersService.list();
    }

    /**
     * 根据id获取订单
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Orders getById(@PathVariable int id) {
        return ordersService.getById(id);
    }

    /**
     * 删除订单
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){

        return ordersService.removeById(id);

    }

    /**
     * 保存订单
     * @param orders
     * @return
     */
    @PostMapping
    public boolean saveOrders(@RequestBody Orders orders){
        System.out.println("order save!");
        return ordersService.save(orders);
    }



    public Integer initOrders(int type) {
        System.out.println(type);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateFormat.format(date));
        Orders orders = new Orders();
        orders.setOrderStartTime(dateFormat.format(date));
        orders.setOrderType(type);
        orders.setOrderStatus(type*10);
        //设置订单发起人ID 默认为11 需要后续实现
        orders.setOrderInit(11);
        ordersService.save(orders);
        return orders.getOrderId();
    }
}
