package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.controller.UsersController;
import com.example.dao.UsersDao;
import com.example.domain.UploadFile;
import com.example.domain.Users;
import com.example.service.UploadFileTool;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


/**
 * @author ginger
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersDao,Users> implements UsersService {
    private final UsersDao usersDao = null;
    @Autowired
    private final UsersService usersService = null;
    @Autowired
    private final UsersController usersController = new UsersController();
    private final UploadFileTool uploadFileTool = null;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateAvatar(MultipartFile file) {
        Users Users = findByUserName(usersController.getCurrentUsername());
        // 调用上传文件服务保存头像
        UploadFile uploadFile = uploadFileTool.upload(Users.getUserName(), file.getOriginalFilename(), file);
        // 将头像路径保存到个人信息中
        Users.setAvatarUrl(uploadFile.getType() + File.separator  + uploadFile.getFileName());
        return update(Users);

    }

    @Transactional(rollbackFor = Exception.class)
    public boolean update(Users user) {
        if (usersService.updateById(user)) {
            return true;
        }
        throw new RuntimeException("更新用户信息失败");
    }

    public Users findByUserName(String userName) {
        return usersDao.selectUserByName("%" + userName + "%");
    }


    
}
