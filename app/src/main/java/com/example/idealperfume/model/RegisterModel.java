package com.example.idealperfume.model;

import com.google.gson.annotations.SerializedName;

public class RegisterModel {
    @SerializedName("userID")
    String userID;

    @SerializedName("password")
    String password;

    @SerializedName("loginBy")
    String loginBy;

    @SerializedName("nickName")
    String nickName;

    @SerializedName("userName")
    String userName;

    @SerializedName("uPicture")
    String uPicture;

    @SerializedName("gender")
    String gender;

    @SerializedName("job")
    String job;

    @SerializedName("age")
    String age;

    @SerializedName("point")
    String point;

    @SerializedName("agreement")
    String agreement;

    @SerializedName("phone")
    String phone;

    @SerializedName("certification")
    String certification;

    public RegisterModel(String userID, String password, String loginBy, String nickName, String userName, String uPicture, String gender, String job, String age, String point, String agreement, String phone, String certification) {
        this.userID = userID;
        this.password = password;
        this.loginBy = loginBy;
        this.nickName = nickName;
        this.userName = userName;
        this.uPicture = uPicture;
        this.gender = gender;
        this.job = job;
        this.age = age;
        this.point = point;
        this.agreement = agreement;
        this.phone = phone;
        this.certification = certification;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginBy() {
        return loginBy;
    }

    public void setLoginBy(String loginBy) {
        this.loginBy = loginBy;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getuPicture() {
        return uPicture;
    }

    public void setuPicture(String uPicture) {
        this.uPicture = uPicture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }
}
