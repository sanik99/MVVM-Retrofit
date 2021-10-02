package com.example.mvvm_retrofit.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_retrofit.Model.MovieModel;
import com.example.mvvm_retrofit.Network.APIService;
import com.example.mvvm_retrofit.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {


    private MutableLiveData<List<MovieModel>> movieList;
    public MovieListViewModel() {

        movieList = new MutableLiveData<>();
    }

    public MutableLiveData<List<MovieModel>> getMovieList(){
        return movieList;
    }

    public void makeApiCall(){

        APIService apiService = RetrofitInstance.getRetrofitUser().create(APIService.class);
        Call<List<MovieModel>> call = apiService.getMovieModel();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {

                movieList.postValue(response.body());

            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {

                movieList.postValue(null);
            }
        });
    }
}
