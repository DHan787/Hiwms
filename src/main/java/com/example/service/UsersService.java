package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Users;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


/**
 * @author ginger
 */
public interface UsersService extends IService<Users> {
    /**
     * 修改用户头像
     * @param file 文件
     * @return json
     */
     boolean updateAvatar(MultipartFile file);
}
