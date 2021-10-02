package com.example.mvvm_retrofit.Adapter;

import android.content.Context;
import android.gesture.GestureLibraries;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvm_retrofit.Model.MovieModel;
import com.example.mvvm_retrofit.R;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private Context context;
    private List<MovieModel> movieModels;

    public MovieListAdapter(Context context, List<MovieModel> movieModels) {
        this.context = context;
        this.movieModels = movieModels;
    }

    public void setMovieModels(List<MovieModel> movieModels) {

        this.movieModels = movieModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(holder.imageView)
                .load(movieModels.get(position).getImage().getOriginal())
                .into(holder.imageView);

        holder.name.setText(this.movieModels.get(position).getName().toString());
        holder.language.setText(this.movieModels.get(position).getLanguage().toString());
    }

    @Override
    public int getItemCount() {

        if (this.movieModels != null){
            return movieModels.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, language;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            language = itemView.findViewById(R.id.language);
        }
    }
}

