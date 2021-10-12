package com.example.mp2projectmadraman;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Plants {
    @SerializedName("Plants")
    @Expose
    private List<Plants_> plants = null;

    public List<Plants_> getPlants() {
        return plants;
    }

    public void setPlants(List<Plants_> plants) {
        this.plants = plants;
    }

}
