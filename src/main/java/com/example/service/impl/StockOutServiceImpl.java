package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.StockOutDao;
import com.example.domain.StockOut;
import com.example.service.StockOutService;
import org.springframework.stereotype.Service;

/**
 * @author ginger
 */
@Service
public class StockOutServiceImpl extends ServiceImpl<StockOutDao, StockOut> implements StockOutService {
}
