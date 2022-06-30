package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Goods;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GoodsService extends IService<Goods> {
}
