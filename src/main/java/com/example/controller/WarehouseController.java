package com.example.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.dao.WarehouseDao;
import com.example.domain.Warehouse;
import com.example.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author ginger
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private WarehouseDao warehouseDao;

    /**
     * get all warehouse
     * @return list
     */
    @GetMapping
    public List<Warehouse> getAll() {
        log.info("warehouse获取的数据，{}", warehouseService.list());
        return warehouseService.list();
    }

    /**
     * 根据id获取货物
     *
     * @param id id
     * @return warehouse
     */
    @GetMapping("/{id}")
    public Warehouse getById(@PathVariable int id) {
        return warehouseService.getById(id);
    }

    /**
     * 删除货物
     *
     * @param id id
     * @return if success
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return warehouseService.removeById(id);
    }

    /**
     * 保存用户
     *
     * @param warehouse object
     * @return if success
     */
    @PostMapping
    public boolean saveWarehouse(@RequestBody Warehouse warehouse) {
        System.out.println("save!");
        return warehouseService.save(warehouse);
    }

    /**
     * 更新仓库信息
     *
     * @param warehouse object
     * @return if success
     */
    @PutMapping
    public boolean updateWarehouse(@RequestBody Warehouse warehouse) {
        System.out.println(warehouse.getWarehouseName());
        return warehouseService.updateById(warehouse);
    }


    /**
     * find
     * @param warehouseName name
     * @return names
     */
    @GetMapping("/like")
    public List<Warehouse> getAllList(@RequestParam String warehouseName) {
        System.out.println(warehouseName);
        return warehouseDao.selectWarehouseName("%" + warehouseName + "%");
    }

    /**
     * excel导出
     * @param response res
     * @throws Exception exception
     */
    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) throws Exception {
        //查询所有数据
        List<Warehouse> list = warehouseService.list();
        //在内存操作，写出到浏览器，从浏览器下载
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题名
        writer.addHeaderAlias("warehouseId", "仓库编号");
        writer.addHeaderAlias("warehouseName", "仓库名称");
        writer.addHeaderAlias("warehouseLocation", "仓库位置");
        writer.addHeaderAlias("warehouseType", "仓库类别");
        writer.addHeaderAlias("warehouseSize", "仓库大小");

        //一次性写出list内的对象到excel，使用默认格式，强制输出标题
        writer.write(list,true);

        //设置浏览器响应格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("仓库信息","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");

        ServletOutputStream outputStream = response.getOutputStream();
        writer.flush(outputStream,true);

        //关闭流
        outputStream.close();
        writer.close();
    }
}

