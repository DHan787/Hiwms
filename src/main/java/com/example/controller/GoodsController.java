package com.example.controller;

import com.example.domain.Goods;
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

    /**
     * 获取全部货品
     * @return
     */
    @GetMapping//访问方式
    public List<Goods> getAll() {
        //log.info("goods获取的数据，{}",goodsService.list());
        //System.out.println("used");
        return goodsService.list();
    }

    /**
     * 根据id获取货物
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Goods getById(@PathVariable int id) {
        return goodsService.getById(id);
    }

    /**
     * 删除货物
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){

        return goodsService.removeById(id);

    }

    /**
     * 保存用户
     * @param goods
     * @return
     */
    @PostMapping
    public boolean saveGoods(@RequestBody Goods goods){
        System.out.println("save!");
        return goodsService.save(goods);
    }

    /**
     *更新商品信息
     * @param goods 商品对象
     * @return if success
     */
    @PutMapping
    public boolean updateGoods(@RequestBody Goods goods){
        System.out.println(goods.getGoodsName());
        return goodsService.updateById(goods);
    }

}
