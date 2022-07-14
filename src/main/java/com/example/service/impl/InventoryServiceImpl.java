package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.InventoryDao;
import com.example.domain.Inventory;
import com.example.service.InventoryService;
import org.springframework.stereotype.Service;

/**
 * @author ginger
 */
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryDao, Inventory> implements InventoryService {

}
