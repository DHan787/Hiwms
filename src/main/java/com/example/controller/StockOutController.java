package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.config.StockInEvent;
import com.example.config.StockOutEvent;
import com.example.dao.StockOutDao;
import com.example.domain.StockOut;
import com.example.service.StockOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author ginger
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/stockOut")
public class StockOutController {

    @Autowired
    private StockOutService stockOutService;

    @Autowired
    private StockOutDao stockOutDao;

    @Autowired
    private WebApplicationContext webapplicationcontext;


    OrdersController ordersController;

    public StockOutController(OrdersController ordersController) {
        this.ordersController = ordersController;
    }

    /**
     * 获取全部入库信息
     * @return list
     */
    @GetMapping//访问方式
    public List<StockOut> getAll() {
        System.out.println(stockOutService.list());
        return stockOutService.list();
    }

    /**
     * @param stockOut 对象
     * @return if success
     */
    @PostMapping("/save")
    public boolean saveStockOut(@RequestBody StockOut stockOut) {
        //type = 2 入库
        stockOut.setOrderId(ordersController.initOrders(2));
        Integer id = stockOut.getStockId();
        StockOutEvent stockOutEvent=new StockOutEvent("stockIn:",stockOut,"新的出库申请",id);
        webapplicationcontext.publishEvent(stockOutEvent);
        return stockOutService.save(stockOut);
    }

    /**
     * 根据订单ID得到出库货品信息
     *
     * @param orderId id
     * @return 出库信息
     */
    @GetMapping("/getByOrderId")
    public List<StockOut> getByOrderId(@RequestParam Integer orderId) {

        QueryWrapper<StockOut> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id", orderId);
        return stockOutDao.selectList(wrapper);
    }

    /**
     * 删除出库申请记录
     *
     * @param id id
     * @return if success
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {

        return stockOutService.removeById(id);

    }

}
