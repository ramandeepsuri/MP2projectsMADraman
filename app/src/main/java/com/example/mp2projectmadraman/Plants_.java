package com.example.mp2projectmadraman;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plants_ implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("habit")
    @Expose
    private String habit;
    @SerializedName("lifespan")
    @Expose
    private String lifespan;
    @SerializedName("exposure")
    @Expose
    private String exposure;
    @SerializedName("water")
    @Expose
    private String water;
    @SerializedName("features")
    @Expose
    private String features;
    @SerializedName("species")
    @Expose
    private String species;

    protected Plants_(Parcel in) {
        name = in.readString();
        image = in.readString();
        habit = in.readString();
        lifespan = in.readString();
        exposure = in.readString();
        water = in.readString();
        features = in.readString();
        species = in.readString();
    }

    public static final Parcelable.Creator<Plants_> CREATOR = new Parcelable.Creator<Plants_>() {
        @Override
        public Plants_ createFromParcel(Parcel in) {
            return new Plants_(in);
        }

        @Override
        public Plants_[] newArray(int size) {
            return new Plants_[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public String getLifespan() {
        return lifespan;
    }

    public void setLifespan(String lifespan) {
        this.lifespan = lifespan;
    }

    public String getExposure() {
        return exposure;
    }

    public void setExposure(String height) {
        this.exposure = exposure;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public int describeContents() {
        return 0;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(habit);
        dest.writeString(lifespan);
        dest.writeString(exposure);
        dest.writeString(water);
        dest.writeString(features);
        dest.writeString(species);
    }
}

