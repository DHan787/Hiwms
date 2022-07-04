package com.example.controller;


import com.example.domain.StockOut;
import com.example.service.StockOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/stockOut")
public class StockOutController {

    @Autowired
    private StockOutService stockOutService;

    OrdersController ordersController;

    public StockOutController(OrdersController ordersController) {
        this.ordersController = ordersController;
    }
    /**
     * 获取全部入库信息
     * @return
     */
    @GetMapping//访问方式
    public List<StockOut> getAll() {
        System.out.println(stockOutService.list());
        return stockOutService.list();
    }

    /**
     *
     * @param stockOut
     * @return if success
     */
    @PostMapping("/save")
    public boolean saveStockOut(@RequestBody StockOut stockOut){
        stockOut.setStockId(ordersController.initOrders(2)); //type = 2 入库
        return stockOutService.save(stockOut);
    }

}
