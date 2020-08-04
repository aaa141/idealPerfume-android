package com.example.idealperfume.Data;

public class MyPickData {
    private String name;
    private String name_eng;
    private String desc;
    private int icon;

//    public MyPickData() {
//    }

    public MyPickData(String name, String name_eng, String desc, int icon) {
        this.name = name;
        this.name_eng = name_eng;
        this.desc = desc;
        this.icon = icon;
    }

    // getter
    public String getProductName() {
        return name;
    }

    public String getName_eng() {
        return name_eng;
    }

    public String getDesc() {
        return desc;
    }

    public int getIcon() {
        return icon;
    }

    //setter
    public void setProductName(String productName) {
        name = productName;
    }

    public void setName_eng(String name_eng) {
        this.name_eng = name_eng;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
