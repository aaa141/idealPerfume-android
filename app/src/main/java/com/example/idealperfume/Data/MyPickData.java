package com.example.idealperfume.Data;

public class MyPickData {
    private String name;
    private String sub;
    private String desc;
    private int icon;
    private int ViewType;

    public MyPickData(String name, String sub, String desc, int icon, int ViewType) {
        this.name = name;
        this.sub = sub;
        this.desc = desc;
        this.icon = icon;
        this.ViewType = ViewType;
    }

    // getter
    public String getProductName() {
        return name;
    }

    public String getSub() { return sub; }

    public String getDesc() {
        return desc;
    }

    public int getIcon() {
        return icon;
    }

    public int getViewType() { return ViewType; }


    //setter
    public void setProductName(String productName) { this.name = productName; }

    public void setSub(String sub) { this.sub = sub; }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setViewType(int viewType) { ViewType = viewType; }


    public class Code {
        public class ViewType {
            public static final int ProductListItem = 0;
            public static final int FolderListItem = 1;
        }
    }
}
