package com.example.controller;

import com.example.domain.StockIn;
import com.example.service.StockInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/stockIn")
/**
 * 入库订单生成逻辑
 * 前端传来物品名称和数量
 */
public class StockInController {

    @Autowired
    private StockInService stockInService;

    private OrdersController ordersController;

    public StockInController(OrdersController ordersController) {
        this.ordersController = ordersController;
    }

    /**
     * 获取全部入库信息
     * @return
     */
    @GetMapping//访问方式
    public List<StockIn> getAll() {
        System.out.println(stockInService.list());
        return stockInService.list();
    }

    /**
     *
     * @param stockIn 对象
     * @return if success
     */
    @PostMapping("/save")
    public boolean saveStockIn(@RequestBody StockIn stockIn){
        stockIn.setOrderId(ordersController.initOrdersIn());

        return stockInService.save(stockIn);
    }

}
