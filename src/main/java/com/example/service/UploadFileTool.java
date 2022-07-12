package com.example.service;

import com.example.domain.UploadFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传工具接口
 * @author ginger
 */
public interface UploadFileTool {
    /**
     * 文件上传
     *
     * @param uploader  上传人
     * @param realName  文件实际名称
     * @param multipartFile 文件
     * @return 上传信息
     */
    UploadFile upload(String uploader, String realName, MultipartFile multipartFile);
}

