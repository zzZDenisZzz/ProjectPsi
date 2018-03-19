package com.psi.projectpsi.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PsiModel {

    @SerializedName("first")
    @Expose
    private String first;
    @SerializedName("second")
    @Expose
    private String second;
    @SerializedName("third")
    @Expose
    private String third;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

}