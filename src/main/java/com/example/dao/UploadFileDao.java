package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.UploadFile;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ginger
 */
@Mapper
public interface UploadFileDao extends BaseMapper<UploadFile> {
}
