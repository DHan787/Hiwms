package com.example.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.dao.WarehouseDao;
import com.example.domain.Goods;
import com.example.domain.Warehouse;
import com.example.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/warehouse")
public class WarehosueController {
    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private WarehouseDao warehouseDao;

    /**
     * 获取全部货品
     *
     * @return
     */
    @GetMapping//访问方式
    public List<Warehouse> getAll() {
        log.info("warehouse获取的数据，{}", warehouseService.list());
        //System.out.println("used");
        return warehouseService.list();
    }

    /**
     * 根据id获取货物
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Warehouse getById(@PathVariable int id) {
        return warehouseService.getById(id);
    }

    /**
     * 删除货物
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {

        return warehouseService.removeById(id);

    }

    /**
     * 保存用户
     *
     * @param warehouse
     * @return
     */
    @PostMapping
    public boolean saveWarehouse(@RequestBody Warehouse warehouse) {
        System.out.println("save!");
        return warehouseService.save(warehouse);
    }

    /**
     * 更新仓库信息
     *
     * @param warehouse
     * @return if success
     */
    @PutMapping
    public boolean updateWarehouse(@RequestBody Warehouse warehouse) {
        System.out.println(warehouse.getWarehouseName());
        return warehouseService.updateById(warehouse);
    }


    //模糊查询
    @GetMapping("/like")
    public List<Warehouse> getAllList(@RequestParam String warehouseName) {
        System.out.println(warehouseName);
        return warehouseDao.selectWarehouseName("%" + warehouseName + "%");
    }

    /**
     * excel导出
     * @param response
     * @throws Exception
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

