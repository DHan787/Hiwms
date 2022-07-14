package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.OrdersDao;
import com.example.service.OrdersService;
import com.example.domain.Orders;
import org.springframework.stereotype.Service;



/**
 * @author ginger
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersDao,Orders> implements OrdersService {

}
