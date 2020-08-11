package com.example.idealperfume.Data;

public class RankingData {
    private int rank;
    private int change;
    private int productimg;
    private String name;
    private String name_eng;
    private String desc;

    public RankingData(int rank, int change, int productimg, String name, String name_eng, String desc) {
        this.rank = rank;
        this.change = change;
        this.productimg = productimg;
        this.name = name;
        this.name_eng = name_eng;
        this.desc = desc;
    }

    //getter
    public int getRank() {
        return rank;
    }

    public int getChange() {
        return change;
    }

    public int getProductimg() {
        return productimg;
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

    public void setRank(int rank) { this.rank = rank; }

    public void setChange(int change) {
        this.change = change;
    }

    public void setProductimg(int productimg) {
        this.productimg = productimg;
    }

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
