package com.example.idealperfume.Data;

public class MainCategoryData {
    int iv_category;
    String tv_category;

    public MainCategoryData(int iv_category, String tv_category) {
        this.iv_category = iv_category;
        this.tv_category = tv_category;
    }

    public int getIv_category() {
        return iv_category;
    }

    public void setIv_category(int iv_category) {
        this.iv_category = iv_category;
    }

    public String getTv_category() {
        return tv_category;
    }

    public void setTv_category(String tv_category) {
        this.tv_category = tv_category;
    }
}
