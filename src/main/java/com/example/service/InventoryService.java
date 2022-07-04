package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Inventory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InventoryService extends IService<Inventory> {
}
