package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.StockIn;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StockInService extends IService<StockIn> {
}
