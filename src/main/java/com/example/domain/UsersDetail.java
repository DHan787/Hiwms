package com.example.domain;

import lombok.Data;

/**
 * @author ginger
 */
@Data
/**
 * DTO类 组合user 和 userinfo
 */
public class UsersDetail {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户电话号码
     */
    private Long userTele;
    /**
     * 用户地址
     */
    private String userLocation;
    /**
     * 用户所在零售商、
     */
    private String userRetailer;
    /**
     * 用户角色
     */
    private String userRole;
    /**
     *用户信息创建时间
     */
    private Long usersInfoAltTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserTele() {
        return userTele;
    }

    public void setUserTele(Long userTele) {
        this.userTele = userTele;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserRetailer() {
        return userRetailer;
    }

    public void setUserRetailer(String userRetailer) {
        this.userRetailer = userRetailer;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UsersDetail{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userTele=" + userTele +
                ", userLocation='" + userLocation + '\'' +
                ", userRetailer='" + userRetailer + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
