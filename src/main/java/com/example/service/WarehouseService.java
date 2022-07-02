package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Warehouse;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WarehouseService extends IService<Warehouse> {
}
