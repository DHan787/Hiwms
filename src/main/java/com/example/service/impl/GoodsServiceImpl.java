package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.GoodsDao;
import com.example.domain.Goods;
import com.example.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, Goods> implements GoodsService {
}
