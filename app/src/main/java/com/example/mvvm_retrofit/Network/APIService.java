package com.example.mvvm_retrofit.Network;

import com.example.mvvm_retrofit.Model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("shows")
    Call<List<MovieModel>> getMovieModel();
}
