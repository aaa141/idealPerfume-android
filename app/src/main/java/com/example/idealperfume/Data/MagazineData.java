package com.example.idealperfume.Data;

public class MagazineData {
    private int magazineImg;
    private String name;
    private String name_eng;
    private String desc;

    public MagazineData(int magazineImg, String name, String name_eng, String desc) {
        this.magazineImg = magazineImg;
        this.name = name;
        this.name_eng = name_eng;
        this.desc = desc;
    }

    //getter
    public int getMagazineImg() {
        return magazineImg;
    }

    public String getName() {
        return name;
    }

    public String getName_eng() {
        return name_eng;
    }

    public String getDesc() {
        return desc;
    }

    //setter

    public void setMagazineImg(int magazineImg) { this.magazineImg = magazineImg; }

    public void setName(String name) {
        this.name = name;
    }

    public void setName_eng(String name_eng) {
        this.name_eng = name_eng;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
