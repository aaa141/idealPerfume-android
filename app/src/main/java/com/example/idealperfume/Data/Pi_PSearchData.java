package com.example.idealperfume.Data;

import android.graphics.drawable.Drawable;

public class Pi_PSearchData {
    private String brandName, prodName, price, starPoint, reviewCnt;
    private int prodImage;
    private boolean heart;

    public Pi_PSearchData(String brandName, String prodName, String price,
                          String starPoint, String reviewCnt, int prodImage, boolean heart) {
        this.brandName = brandName;
        this.prodName = prodName;
        this.price = price;
        this.starPoint = starPoint;
        this.reviewCnt = reviewCnt;
        this.prodImage = prodImage;
        this.heart = heart;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStarPoint() {
        return starPoint;
    }

    public void setStarPoint(String starPoint) {
        this.starPoint = starPoint;
    }

    public String getReviewCnt() {
        return reviewCnt;
    }

    public void setReviewCnt(String reviewCnt) {
        this.reviewCnt = reviewCnt;
    }

    public int getProdImage() {
        return prodImage;
    }

    public void setProdImage(int prodImage) {
        this.prodImage = prodImage;
    }

    public boolean isHeart() {
        return heart;
    }

    public void setHeart(boolean heart) {
        this.heart = heart;
    }
}
