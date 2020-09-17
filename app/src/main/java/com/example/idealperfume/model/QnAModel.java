package com.example.idealperfume.model;

import com.google.gson.annotations.SerializedName;

public class QnAModel {
    @SerializedName("uID")
    String uID;

    @SerializedName("type")
    String type;

    @SerializedName("detail")
    String detail;

    @SerializedName("email")
    String email;

    public QnAModel(String uID, String type, String detail, String email) {
        this.uID = uID;
        this.type = type;
        this.detail = detail;
        this.email = email;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}