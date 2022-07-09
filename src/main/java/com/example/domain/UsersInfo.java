package com.example.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ginger
 */
@Data
@TableName("users_info")
public class UsersInfo{
    @TableId("users_Info_id")
    private Long usersInfoId;
//    用户电话号码
    private Long userTele;
//    用户地址
    private String userLocation;
//    用户商家名
    private String userRetailer;
//    用户信息修改时间
    private Long userAltTime;

    @Override
    public String toString() {
        return "UsersInfo{" +
                "usersInfoId=" + usersInfoId +
                ", userTele=" + userTele +
                ", userLocation='" + userLocation + '\'' +
                ", userRetailer='" + userRetailer + '\'' +
                ", userAltTime=" + userAltTime +
                '}';
    }
}
