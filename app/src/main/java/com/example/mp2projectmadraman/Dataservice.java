package com.example.mp2projectmadraman;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {

    @GET("v3/999bfb26-7102-4c11-8923-f6de74ea47c0")
    Call<Plants> getAllPlants();

}
