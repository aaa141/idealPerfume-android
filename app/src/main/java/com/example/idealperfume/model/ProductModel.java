package com.example.idealperfume.model;

import com.google.gson.annotations.SerializedName;

public class ProductModel {
    @SerializedName("name")
    String name;
    @SerializedName("price")
    int price;
    @SerializedName("capacity")
    String capacity;
    @SerializedName("bName")
    String bName;
    @SerializedName("bImage")
    String bImage;
    @SerializedName("bIntro")
    String bIntro;

    public ProductModel(String name, int price, String capacity, String bName, String bImage, String bIntro) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.bName = bName;
        this.bImage = bImage;
        this.bIntro = bIntro;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getbName() {
        return bName;
    }

    public String getbImage() {
        return bImage;
    }

    public String getbIntro() {
        return bIntro;
    }
}
