package com.example.idealperfume.model;

import com.google.gson.annotations.SerializedName;

public class MaterialModel {
    @SerializedName("mName")
    String mName;

    @SerializedName("mIntro")
    String mIntro;

    @SerializedName("mImage")
    String mImage;

    public MaterialModel(String mName, String mIntro, String mImage) {
        this.mName = mName;
        this.mIntro = mIntro;
        this.mImage = mImage;
    }

    public String getmName() {
        return mName;
    }

    public String getmIntro() {
        return mIntro;
    }

    public String getmImage() {
        return mImage;
    }
}


