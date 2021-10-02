package com.example.mvvm_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvm_retrofit.Adapter.MovieListAdapter;
import com.example.mvvm_retrofit.Model.MovieModel;
import com.example.mvvm_retrofit.ViewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcView;
    MovieListAdapter adapter;
    private List<MovieModel> movieModelsList;
    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        rcView = findViewById(R.id.rcView);
        LinearLayoutManager layoutManager = new GridLayoutManager(this, 3);
        rcView.setLayoutManager(layoutManager);
        adapter = new MovieListAdapter(this, movieModelsList );
        rcView.setAdapter(adapter);


        movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        movieListViewModel.getMovieList().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if (movieModels != null){
                    movieModelsList = movieModels;
                    adapter.setMovieModels(movieModels);
                } else {

                    Toast.makeText(MainActivity.this, "Error : No results found" , Toast.LENGTH_SHORT).show();

                }
            }
        });

        movieListViewModel.makeApiCall();

    }
}