package com.example.idealperfume.model;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.FormUrlEncoded;

public class FolderModel {
    @SerializedName("uID")
    String uID;

    @SerializedName("fName")
    String fName;

    @SerializedName("infID")
    String infID;

    public FolderModel(String uID, String fName, String infID) {
        this.uID = uID;
        this.fName = fName;
        this.infID = infID;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getInfID() {
        return infID;
    }

    public void setInfID(String infID) {
        this.infID = infID;
    }
}
