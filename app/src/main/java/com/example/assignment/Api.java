package com.example.assignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("crew")
    Call<List<Crew>> getdata();
}
