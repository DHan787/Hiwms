package com.example.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.vo.InventoryVo;
import com.example.dao.InventoryDao;
import com.example.domain.Goods;
import com.example.domain.Inventory;
import com.example.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryDao inventoryDao;

    /**
     * 获取全部库存
     *
     * @return
     */
    @GetMapping//访问方式
    public List<Inventory> getAll() {
        return inventoryService.list();
    }

    /**
     * 根据id获取货物
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Inventory getById(@PathVariable int id) {

        return inventoryService.getById(id);
    }

    //模糊查询
    @GetMapping("/like")
    public List<Inventory> getAllList(@RequestParam String inventoryId, @RequestParam String goodsName) {
        System.out.println(inventoryId + goodsName);
        return inventoryDao.selectInventory("%" + inventoryId + "%", "%" + goodsName + "%");
    }

    /**
     * excel导出
     * @param response
     * @throws Exception
     */
    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) throws Exception {
        //查询所有数据
        List<Inventory> list = inventoryService.list();
        //在内存操作，写出到浏览器，从浏览器下载
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题名
        writer.addHeaderAlias("inventoryId", "库存编号");
        writer.addHeaderAlias("goodsName", "货物名称");
        writer.addHeaderAlias("goodsNumber", "货物数量");
        writer.addHeaderAlias("warehouseName", "仓库名称");

        //一次性写出list内的对象到excel，使用默认格式，强制输出标题
        writer.write(list,true);

        //设置浏览器响应格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("库存信息","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");

        ServletOutputStream outputStream = response.getOutputStream();
        writer.flush(outputStream,true);

        //关闭流
        outputStream.close();
        writer.close();
    }


    /**
     * 删除库存
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {

        return inventoryService.removeById(id);

    }

    /**
     * 保存库存
     *
     * @param inventory
     * @return
     */
    @PostMapping
    public boolean saveInventory(@RequestBody Inventory inventory) {
//        System.out.println("save!");
//        System.out.println(inventory);
        return inventoryService.save(inventory);
    }

    /**
     * 更新库存
     *
     * @param inventory
     * @return if success
     */
    @PutMapping
    public boolean updateInventory(@RequestBody Inventory inventory) {

        return inventoryService.updateById(inventory);
    }

    /**
     * 入库-根据入库订单表stockin更新库存
     *
     * @param goodsName
     * @param goodsNumber
     * @return
     */
    @PutMapping("/stockIn")
    public int updateStockIn(@RequestParam String goodsName, @RequestParam String goodsNumber) {
        QueryWrapper<Inventory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_name", goodsName); //根据货物名称查询到该条记录
        Inventory inventory = inventoryService.getOne(queryWrapper);

        Integer inventoryNumber = Integer.parseInt(inventory.getGoodsNumber()); //将string类型的库存数转换为整型
        log.info("之前的库存数：", inventoryNumber);
        Integer inventoryNumberNew = inventoryNumber + Integer.parseInt(goodsNumber); //原库存数加上新入库的数量
        log.info("入库后的库存数：", inventoryNumberNew);
        String goodsNumberNew = String.valueOf(inventoryNumberNew); //将现在的库存数（整型）转换为字符串

        UpdateWrapper<Inventory> updateWrapper = new UpdateWrapper<>();  //更新
        updateWrapper.eq("goods_name", goodsName).set("goods_number", goodsNumberNew);
        return inventoryDao.update(null, updateWrapper);
    }

    /**
     * 出库-根据出库订单表stockout更新库存
     *
     * @param goodsName
     * @param goodsNumber
     * @return
     */
    @PutMapping("/stockOut")
    public int updateStockOut(@RequestParam String goodsName, @RequestParam String goodsNumber) {
        QueryWrapper<Inventory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_name", goodsName); //根据货物名称查询到该条记录
        Inventory inventory = inventoryService.getOne(queryWrapper);

        Integer inventoryNumber = Integer.parseInt(inventory.getGoodsNumber()); //将string类型的库存数转换为整型
        log.info("之前的库存数：", inventoryNumber);
        Integer inventoryNumberNew = inventoryNumber - Integer.parseInt(goodsNumber); //原库存数加上新入库的数量
        log.info("入库后的库存数：", inventoryNumberNew);
        String goodsNumberNew = String.valueOf(inventoryNumberNew); //将现在的库存数（整型）转换为字符串

        UpdateWrapper<Inventory> updateWrapper = new UpdateWrapper<>();  //更新
        updateWrapper.eq("goods_name", goodsName).set("goods_number", goodsNumberNew);
        return inventoryDao.update(null, updateWrapper);
    }


    /**
     * 获取制作图表所需的数据
     *
     * @return
     */
    @GetMapping("/getBarList")
    public InventoryVo getInventoryBarList() {
        List<Inventory> inventories = inventoryService.list();

        InventoryVo inventoryVo = new InventoryVo();
        List<String> names = new ArrayList<>();
        List<String> values = new ArrayList<>();
        for (Inventory inventory : inventories) {
            names.add(inventory.getGoodsName());
            values.add(inventory.getGoodsNumber());
        }
        inventoryVo.setName(names);
        inventoryVo.setValue(values);
        return inventoryVo;
    }

}
