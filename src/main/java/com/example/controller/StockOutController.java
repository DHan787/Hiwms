package com.example.controller;

import com.example.domain.StockIn;
import com.example.domain.StockOut;
import com.example.service.StockOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/stockout")
public class StockOutController {

    @Autowired
    private StockOutService stockOutService;

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
     * @param id orderId
     * @return if success
     */
    @PostMapping("/save")
    public boolean saveStockOut(@RequestBody StockOut stockOut, Integer id){
        stockOut.setStockId(id);
        return stockOutService.save(stockOut);
    }

}
