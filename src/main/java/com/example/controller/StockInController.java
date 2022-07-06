package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.StockInDao;
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

    @Autowired
    private StockInDao stockInDao;

    public StockInController(OrdersController ordersController) {

        this.ordersController = ordersController;
    }

    OrdersController ordersController;


    /**
     * 获取全部入库信息
     * @return list
     */
    @GetMapping//访问方式
    public List<StockIn> getAll() {
        System.out.println(stockInService.list());
        return stockInService.list();
    }

    /**
     * @param stockIn 对象
     * @return if success
     */
    @PostMapping("/save")
    public boolean saveStockIn(@RequestBody StockIn stockIn) {
        stockIn.setOrderId(ordersController.initOrders(1));// type = 1 入库
        return stockInService.save(stockIn);
    }

    /**
     * 根据订单ID得到入库货品信息
     * @param orderId
     * @return
     */
    @GetMapping("/getByOrderId")
    public List<StockIn> getByOrderId(@RequestParam Integer orderId){

        QueryWrapper<StockIn> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id",orderId);
        List<StockIn> stockIns = stockInDao.selectList(wrapper);
        return stockIns;
    }


    /**
     * 删除入库申请记录
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){

        return stockInService.removeById(id);

    }


}
