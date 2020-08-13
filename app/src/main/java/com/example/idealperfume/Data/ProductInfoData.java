package com.example.idealperfume.Data;

public class ProductInfoData {
    private int productImg;     //제품 사진
    private String brand;       //브랜드
    private String name;        //제품 명
    private int price;          //제품 가격
    //private int                 //별점


    public ProductInfoData(int productImg, String brand, String name, int price) {
        this.productImg = productImg;
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public int getProductImg() {
        return productImg;
    }

    public void setProductImg(int productImg) {
        this.productImg = productImg;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
