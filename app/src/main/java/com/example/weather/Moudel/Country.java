package com.example.weather.Moudel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country {

    @SerializedName("name")
    private String name;
    @SerializedName("region")
    private String region;
    @SerializedName("latlng")
    private List<Double> latlng;
    @SerializedName("flag")
    private String flag;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }



    public Country(String name, String region, List<Double> latlng, String flag) {
        this.name = name;
        this.region = region;
        this.latlng = latlng;
        this.flag = flag;
    }
}
