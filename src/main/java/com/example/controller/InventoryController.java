package com.example.controller;


import com.example.dao.GoodsDao;
import com.example.dao.InventoryDao;
import com.example.domain.Goods;
import com.example.domain.Inventory;
import com.example.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @return
     */
    @GetMapping//访问方式
    public List<Inventory> getAll() {
        return inventoryService.list();
    }

    /**
     * 根据id获取货物
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Inventory getById(@PathVariable int id) {

        return inventoryService.getById(id);
    }

    /**
     * 删除库存
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){

        return inventoryService.removeById(id);

    }

    /**
     * 保存库存
     * @param inventory
     * @return
     */
    @PostMapping
    public boolean saveInwentory(@RequestBody Inventory inventory){
        System.out.println("save!");
        return inventoryService.save(inventory);
    }

    /**
     * 更新库存
     * @param inventory
     * @return if success
     */
    @PutMapping
    public boolean updateInventory(@RequestBody Inventory inventory){

        return inventoryService.updateById(inventory);
    }

    //模糊查询
    @GetMapping("/like")
    public List<Inventory> getAllList(@RequestParam String inventoryId,@RequestParam String goodsName){
        System.out.println(inventoryId+goodsName);
        return inventoryDao.selectInventory("%"+inventoryId+"%","%"+goodsName+"%");
    }
}
