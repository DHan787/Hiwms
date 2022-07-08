package com.example.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.dao.GoodsDao;
import com.example.domain.Goods;
import com.example.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsDao goodsDao;

    /**
     * 获取全部货品
     *
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
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Goods getById(@PathVariable int id) {
        return goodsService.getById(id);
    }

    /**
     * 删除货物
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {

        return goodsService.removeById(id);

    }

    /**
     * 保存用户
     *
     * @param goods
     * @return
     */
    @PostMapping
    public boolean saveGoods(@RequestBody Goods goods) {
        System.out.println("save!");
        return goodsService.save(goods);
    }

    /**
     * 更新商品信息
     *
     * @param goods 商品对象
     * @return if success
     */
    @PutMapping
    public boolean updateGoods(@RequestBody Goods goods) {
        System.out.println(goods.getGoodsName());
        return goodsService.updateById(goods);
    }

    //模糊查询
    @GetMapping("/like")
    public List<Goods> getAllList(@RequestParam String goodsName) {
        System.out.println(goodsName);
        return goodsDao.selectGoodsName("%" + goodsName + "%");
    }

    /**
     * excel导出
     * @param response
     * @throws Exception
     */
    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) throws Exception {
        //查询所有数据
        List<Goods> list = goodsService.list();
        //在内存操作，写出到浏览器，从浏览器下载
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题名
        writer.addHeaderAlias("goodsId", "货物编号");
        writer.addHeaderAlias("goodsName", "货物名称");
        writer.addHeaderAlias("goodsType", "货物类别");
        writer.addHeaderAlias("goodsSize", "货物尺寸");
        writer.addHeaderAlias("goodsValue", "货物价格");

        //一次性写出list内的对象到excel，使用默认格式，强制输出标题
        writer.write(list,true);

        //设置浏览器响应格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("货物信息","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");

        ServletOutputStream outputStream = response.getOutputStream();
        writer.flush(outputStream,true);

        //关闭流
        outputStream.close();
        writer.close();
    }


    /**
     * excel导入
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/importExcel")
    public Boolean importExcel(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);

        //方式1：通过JavaBean的方式读取excel内的对象，但是要求表头必须市英文，和JavaBean属性对应
//        List<User> users = reader.readAll(User.class);

        //方式二：忽略表头中文，直接获取表格数据
        List<List<Object>> list = reader.read(1);
        List<Goods> good = CollUtil.newArrayList();

        for(List<Object> row:list){
            Goods goods =new Goods();
            goods.setGoodsName(row.get(1).toString());
            goods.setGoodsType(row.get(2).toString());
            goods.setGoodsSize(row.get(3).toString());
            goods.setGoodsValue(row.get(4).toString());

            good.add(goods);
        }

        //将excel导入的数据保存到数据库
        goodsService.saveBatch(good);
        return true;
    }
}
