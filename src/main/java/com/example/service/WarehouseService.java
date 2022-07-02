package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WarehouseService extends IService<Warehouse> {
}
