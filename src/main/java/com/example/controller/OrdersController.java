package com.example.controller;


import com.example.domain.Orders;
import com.example.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
}
