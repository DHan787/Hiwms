package com.example.controller;

import com.example.domain.Inventory;
import com.example.domain.LowWarning;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/warning")
public class LowWarningController {
    @Autowired
    private LowWarningController lowWarningController;

    @Autowired
    private InventoryController inventoryController;

    List<String> WarnList = new ArrayList<String>();

    @GetMapping()
    public List<String> WarningInfo() {
        getWarnInfo();
        return WarnList;
    }

    public List<LowWarning> getAll() {
        return lowWarningController.getAll();
    }

    private void getWarnInfo() {
        List<Inventory> inventories = inventoryController.getAll();
        List<LowWarning> lowWarnings = lowWarningController.getAll();
        for (LowWarning value : lowWarnings
        ) {
            for (Inventory invent : inventories
            ) {
                if (value.getMinNum() >= invent.getGoodsNumber()) {
                }
                WarnList.add(invent.getGoodsName());
            }
        }
    }
}
