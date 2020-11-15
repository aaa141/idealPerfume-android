package com.example.idealperfume.model;

import com.google.gson.annotations.SerializedName;

public class ThreeReviewModel {
    @SerializedName("nickname")
    String nickname;
    @SerializedName("createdDate")
    String createdDate;
    @SerializedName("rating")
    String  rating;
    @SerializedName("adv")
    String adv;
    @SerializedName("ddv")
    String ddv;
    @SerializedName("helpful")
    String  helpful;
    @SerializedName("hashs")
    String hashs;
    @SerializedName("tcCount")
    String tcCount;

    public ThreeReviewModel(String nickname, String createdDate, String rating, String adv, String ddv, String helpful, String hashs, String  tcCount) {
        this.nickname = nickname;
        this.createdDate = createdDate;
        this.rating = rating;
        this.adv = adv;
        this.ddv = ddv;
        this.helpful = helpful;
        this.hashs = hashs;
        this.tcCount = tcCount;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getRating() {
        return rating;
    }

    public String getAdv() {
        return adv;
    }

    public String getDdv() {
        return ddv;
    }

    public String getHelpful() {
        return helpful;
    }

    public String getHashs() {
        return hashs;
    }

    public String getTcCount() {
        return tcCount;
    }
}
