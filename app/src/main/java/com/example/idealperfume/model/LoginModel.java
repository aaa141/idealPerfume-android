package com.example.idealperfume.model;

import com.google.gson.annotations.SerializedName;

public class LoginModel {

    @SerializedName("userID")
    String userID;

    @SerializedName("loginBy")
    String loginBy;


    public LoginModel(String userID, String loginBy) {
        this.userID = userID;
        this.loginBy = loginBy;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLoginBy() {
        return loginBy;
    }

    public void setLoginBy(String loginBy) {
        this.loginBy = loginBy;
    }
}
