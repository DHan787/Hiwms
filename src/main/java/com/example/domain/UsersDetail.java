package com.example.domain;
@Data
public class UsersDetail {
    private Integer userId;
    private String userName;
    private Long userTele;
    private String userLocation;
    private String userRetailer;
    private String userRole;

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
