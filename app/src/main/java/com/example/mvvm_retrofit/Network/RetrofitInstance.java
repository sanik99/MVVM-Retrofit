package com.example.mvvm_retrofit.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public  static String BASE_URL = "https://api.tvmaze.com/";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitUser(){

        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
