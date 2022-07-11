package com.example.controller;

import com.example.domain.Inventory;
import com.example.domain.LowWarning;
import com.example.service.LowWarningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ginger
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/warning")
public class LowWarningController {
    @Autowired
    private LowWarningService lowWarningService;

    @Autowired
    private InventoryController inventoryController;

    List<String> warnList = new ArrayList<>();

    @GetMapping("/warn")
    public List<String> warningInfo() {
        getWarnInfo();
        return warnList;
    }

    @GetMapping
    public List<LowWarning> getAll() {
        return lowWarningService.list();
    }
    private void getWarnInfo() {
        List<Inventory> inventories = inventoryController.getAll();
        List<LowWarning> lowWarnings = this.getAll();
        for (LowWarning value : lowWarnings
        ) {
            for (Inventory invent : inventories
            ) {
                if (value.getGoodsId().equals(invent.getInventoryId())) {
                    System.out.println("in");
                    if (value.getMinNum() >= invent.getGoodsNumber()) {
                        warnList.add(invent.getGoodsName());
                        System.out.println("inside");
                        break;
                    }
                }
            }
            System.out.println(warnList);
        }
    }
}
