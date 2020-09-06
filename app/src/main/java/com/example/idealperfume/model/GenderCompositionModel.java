package com.example.idealperfume.model;

import com.google.gson.annotations.SerializedName;

public class GenderCompositionModel {

    @SerializedName("female")
    int female;
    @SerializedName("male")
    int male;

    public GenderCompositionModel(int female, int male) {
        this.female = female;
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public int getMale() {
        return male;
    }
}
