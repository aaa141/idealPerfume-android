package com.example.idealperfume.Data;

public class MaterialsData {
    private int icon;
    private String name;
    private String desc;
    private int rate;

    public MaterialsData(int icon, String name, String desc, int rate) {
        this.icon = icon;
        this.name = name;
        this.desc = desc;
        this.rate = rate;
    }

    // getter
    public String getMaterialName() {
        return name;
    }

    public String getMaterialDesc() {
        return desc;
    }

    public int getRate() {
        return rate;
    }

    public int getMaterialIcon() { return icon; }


    //setter

    public void setMaterialIcon(int icon) { this.icon = icon; }
    public void setMaterialName(String productName) {
        this.name = productName;
    }

    public void setMaterialDesc(String desc) {
        this.desc = desc;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}

