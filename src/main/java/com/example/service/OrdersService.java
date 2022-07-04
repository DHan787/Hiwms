package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Orders;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OrdersService extends IService<Orders> {
}
