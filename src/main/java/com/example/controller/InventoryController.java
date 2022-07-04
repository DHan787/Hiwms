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


    @PutMapping
    public boolean updateInventory(@RequestBody Inventory inventory){

        return inventoryService.updateById(inventory);
    }
}
