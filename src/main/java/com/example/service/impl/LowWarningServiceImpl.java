package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.LowWarningDao;
import com.example.domain.LowWarning;
import com.example.service.LowWarningService;
import org.springframework.stereotype.Service;

/**
 * @author ginger
 */
@Service
public class LowWarningServiceImpl extends ServiceImpl<LowWarningDao, LowWarning> implements LowWarningService{
}
