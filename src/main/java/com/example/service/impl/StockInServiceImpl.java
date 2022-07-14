package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.StockInDao;
import com.example.domain.StockIn;
import com.example.service.StockInService;
import org.springframework.stereotype.Service;

/**
 * @author ginger
 */
@Service
public class StockInServiceImpl extends ServiceImpl<StockInDao, StockIn> implements StockInService {
}
