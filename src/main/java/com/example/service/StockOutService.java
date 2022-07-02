package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.StockOut;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StockOutService extends IService<StockOut> {
}
