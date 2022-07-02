package com.example.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users_info")
public class UsersInfo {
    @TableId("users_Info_id")
//    用户信息ID
    private Long usersInfoId;
//    用户电话号码
    private Long usersInfoTele;
//    用户地址
    private String usersInfoLocation;
//    用户商家名
    private String usersInfoRetailer;
//    用户信息修改时间
    private Long usersInfoAltTime;


    public void setUsersInfoId(Long usersInfo_id) {
        this.usersInfoId = usersInfo_id;
    }

}
