package com.example.controller;

import com.example.domain.StockIn;
import com.example.service.StockInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/stockin")
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
}
