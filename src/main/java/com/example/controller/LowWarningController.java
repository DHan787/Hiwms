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

    /**
     *内部类 包含是否是低库存商品字段
     */
    static class LowWarningAll {
        private Integer inventoryId;
        private String goodsName;
        private Integer goodsNumber;
        private String warehouseName;
        private Integer ifLow;

        @Override
        public String toString() {
            return "LowWarningAll{" +
                    "inventoryId=" + inventoryId +
                    ", goodsName='" + goodsName + '\'' +
                    ", goodsNumber=" + goodsNumber +
                    ", warehouseName='" + warehouseName + '\'' +
                    ", ifLow=" + ifLow +
                    '}';
        }

        public Integer getInventoryId() {
            return inventoryId;
        }

        public void setInventoryId(Integer inventoryId) {
            this.inventoryId = inventoryId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public Integer getGoodsNumber() {
            return goodsNumber;
        }

        public void setGoodsNumber(Integer goodsNumber) {
            this.goodsNumber = goodsNumber;
        }

        public String getWarehouseName() {
            return warehouseName;
        }

        public void setWarehouseName(String warehouseName) {
            this.warehouseName = warehouseName;
        }

        public Integer getIfLow() {
            return ifLow;
        }

        public void setIfLow(Integer ifLow) {
            this.ifLow = ifLow;
        }

        public void setLowWarningAll(Integer id, String name, Integer num, String wareName, Integer ifLow) {
            this.inventoryId = id;
            this.goodsName = name;
            this.goodsNumber = num;
            this.warehouseName = wareName;
            this.ifLow = ifLow;
        }
    }

    List<LowWarningAll> lowWarningAllList = new ArrayList<>();

    /**
     * 返回低库存列表
     *
     * @return 低库存商品列表
     */
    @GetMapping("/warn")
    public List<String> warningInfo() {
        getWarnInfo();
        return warnList;
    }

    @GetMapping("/warnlist")
    public List<LowWarningAll> warningAllList() {
        getWarnInfo();
        return lowWarningAllList;
    }

    /**
     * @return list
     */
    @GetMapping
    public List<LowWarning> getAll() {
        return lowWarningService.list();
    }

    /**
     * getWarnInfo
     */
    private void getWarnInfo() {
        List<Inventory> inventories = inventoryController.getAll();
        List<LowWarning> lowWarnings = this.getAll();
        for (Inventory invent : inventories
        ) {
            for (LowWarning value : lowWarnings
            ) {
                LowWarningAll lowWarningAll = new LowWarningAll();
                if (value.getGoodsId().equals(invent.getInventoryId())) {
                    if (value.getMinNum() >= invent.getGoodsNumber()) {
                        warnList.add(invent.getGoodsName());
                        lowWarningAll.setLowWarningAll(invent.getInventoryId(),
                                invent.getGoodsName(),
                                invent.getGoodsNumber(),
                                invent.getWarehouseName(),
                                0);
                    }else{
                        lowWarningAll.setLowWarningAll(invent.getInventoryId(),
                                invent.getGoodsName(),
                                invent.getGoodsNumber(),
                                invent.getWarehouseName(),
                                1);
                    }
                    lowWarningAllList.add(lowWarningAll);
                    break;
                }
            }
        }
    }
}
