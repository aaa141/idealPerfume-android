package com.example.idealperfume.Data;

import android.widget.ImageView;

public class Pi_BSearchData {

    private String brandName, slogan;
    private int brandImage;
    private boolean heart;

    public Pi_BSearchData(String brandName, String slogan, int brandImage, boolean heart) {
        this.brandName = brandName;
        this.slogan = slogan;
        this.brandImage = brandImage;
        this.heart = heart;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public int getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(int brandImage) {
        this.brandImage = brandImage;
    }

    public boolean isHeart() {
        return heart;
    }

    public void setHeart(boolean heart) {
        this.heart = heart;
    }
}
