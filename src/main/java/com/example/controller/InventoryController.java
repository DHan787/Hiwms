package com.example.controller;


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

    /**
     * 获取全部货品
     * @return
     */
    @GetMapping//访问方式
    public List<Inventory> getAll() {
        //log.info("goods获取的数据，{}",goodsService.list());
        //System.out.println("used");
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
     * 删除货物
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){

        return inventoryService.removeById(id);

    }

    /**
     * 保存用户
     * @param inventory
     * @return
     */
    @PostMapping
    public boolean saveInwentory(@RequestBody Inventory inventory){
        System.out.println("save!");
        return inventoryService.save(inventory);
    }


    @PutMapping
    public boolean updateInventory(@RequestBody Inventory inventory){

        return inventoryService.updateById(inventory);
    }
}
