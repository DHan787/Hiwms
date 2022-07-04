package com.example.controller;

import com.example.domain.Orders;
import com.example.domain.StockIn;
import com.example.service.OrdersService;
import com.example.service.StockInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/stockin")
/**
 * 入库订单生成逻辑
 * 前端传来物品名称和数量
 */
public class StockInController {

    @Autowired
    private StockInService stockInService;

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
     * @param stockIn
     * @param id order id
     * @return if success
     */
    @PostMapping("/save")
    public boolean saveStockIn(@RequestBody StockIn stockIn,Integer id){
        stockIn.setStockId(id);
        return stockInService.save(stockIn);
    }

}
