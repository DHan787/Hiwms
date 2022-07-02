package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("users")
@Data
public class Users {
    @TableId("userId")
    private Integer userId;
    private String userName;
    private String userPassword;
    private Integer userRole;
}
