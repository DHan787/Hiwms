package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.LowWarning;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LowWarningService extends IService<LowWarning> {
}
