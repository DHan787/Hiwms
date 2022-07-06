package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.StockInDao;
import com.example.dao.StockOutDao;
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
@RequestMapping("/stockOut")
public class StockOutController {

    @Autowired
    private StockOutService stockOutService;

    @Autowired
    private StockOutDao stockOutDao;


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
//        System.out.println(stockOut);
//        System.out.println("out");
        stockOut.setOrderId(ordersController.initOrders(2)); //type = 2 入库
//        System.out.println(stockOut);
        return stockOutService.save(stockOut);
    }

    /**
     * 根据订单ID得到出库货品信息
     * @param orderId
     * @return
     */
    @GetMapping("/getByOrderId")
    public List<StockOut> getByOrderId(@RequestParam Integer orderId){

        QueryWrapper<StockOut> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id",orderId);
        List<StockOut> stockOuts = stockOutDao.selectList(wrapper);
        return stockOuts;
    }

    /**
     * 删除出库申请记录
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){

        return stockOutService.removeById(id);

    }

}
