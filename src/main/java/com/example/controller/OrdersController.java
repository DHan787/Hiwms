package com.example.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.OrdersDao;
import com.example.dao.GoodsDao;
import com.example.dao.OrdersDao;
import com.example.domain.Goods;
import com.example.domain.Orders;
import com.example.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersDao ordersDao;

    /**
     * 获取订单表
     *
     * @return
     */
    @GetMapping//访问方式
    public List<Orders> getAll() {
        //System.out.println(ordersService.list());
        System.out.println("used");
        return ordersService.list();
    }

    /**
     * 根据id获取订单
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Orders getById(@PathVariable int id) {
        return ordersService.getById(id);
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {

        return ordersService.removeById(id);

    }

    /**
     * 保存订单
     *
     * @param orders
     * @return
     */
    @PostMapping
    public boolean saveOrders(@RequestBody Orders orders) {
        System.out.println("order save!");
        return ordersService.save(orders);
    }


    /**
     * 自动生成订单
     *
     * @param type 订单类型
     * @return 生成的订单id
     */
    public Integer initOrders(int type) {
        //System.out.println(type);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //System.out.println(dateFormat.format(date));
        Orders orders = new Orders();
        orders.setOrderStartTime(dateFormat.format(date));
        orders.setOrderType(type);
        orders.setOrderStatus(type * 10);
        //设置订单发起人ID 默认为11 需要后续实现
        orders.setOrderInit(11);
        ordersService.save(orders);
        return orders.getOrderId();
    }

    /**
     * 订单结束
     *
     * @param orders 订单实体
     * @return if success
     */
    @PostMapping("/endOrders")
    public boolean endOrders(@RequestBody Orders orders) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateFormat.format(date));
        orders.setOrderEndTime(dateFormat.format(date));
        orders.setOrderStatus(orders.getOrderStatus() + 1);
        return ordersService.updateById(orders);
    }

    /**
     * 更新信息
     *
     * @param orders 实体
     * @return if success
     */
    @PostMapping("/check")
    public boolean checkById(@RequestBody Orders orders) {
        orders.setOrderStatus(orders.getOrderStatus() + 1);
        System.out.println(orders);
        return ordersService.updateById(orders);
    }

    /**
     * 根据订单类型获取订单 1-入库 2-出库
     *
     * @param orderType
     * @return
     */
    @GetMapping("/getByType")
    public List<Orders> getByType(@RequestParam Integer orderType, @RequestParam Integer orderStatus) {
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("order_type", orderType);
        wrapper.eq("order_status", orderStatus);
        List<Orders> orders = ordersDao.selectList(wrapper);
        return orders;
    }

    //模糊查询
    @GetMapping("/like")
    public List<Orders> getAllList(@RequestParam String ordersId) {
        System.out.println(ordersId);
        return ordersDao.selectOrdersId("%" + ordersId + "%");
    }

    /**
     * excel导出
     * @param response
     * @throws Exception
     */
    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) throws Exception {
        //查询所有数据
        List<Orders> list = ordersService.list();
        //在内存操作，写出到浏览器，从浏览器下载
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题名
        writer.addHeaderAlias("orderId", "订单编号");
        writer.addHeaderAlias("orderType", "订单类型");
        writer.addHeaderAlias("orderStartTime", "订单开始时间");
        writer.addHeaderAlias("orderEndTime", "订单结束时间");
        writer.addHeaderAlias("orderInit", "订单创建人");
        writer.addHeaderAlias("orderOperator", "订单操作员");
        writer.addHeaderAlias("orderStatus", "订单状态");

        //一次性写出list内的对象到excel，使用默认格式，强制输出标题
        writer.write(list,true);

        //设置浏览器响应格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("订单信息","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");

        ServletOutputStream outputStream = response.getOutputStream();
        writer.flush(outputStream,true);

        //关闭流
        outputStream.close();
        writer.close();
    }
}
