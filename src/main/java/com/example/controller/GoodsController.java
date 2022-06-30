package com.example.controller;

import com.example.domain.Goods;
import com.example.domain.Users;
import com.example.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping//访问方式
    public List<Goods> getAll() {
        log.info("goods获取的数据，{}",goodsService.list());
        System.out.println(goodsService.getById(1));
        System.out.println("used");
        return goodsService.list();
    }
    @GetMapping("/{id}")
    public Goods getById(@PathVariable int id) {
        return goodsService.getById(id);

    }
}
