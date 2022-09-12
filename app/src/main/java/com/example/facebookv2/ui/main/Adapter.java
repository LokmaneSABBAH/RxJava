package com.example.facebookv2.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookv2.R;
import com.example.facebookv2.pojo.PostModel;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MovieViewHolder> {

    private ArrayList<PostModel> postsList = new ArrayList<>();

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.userIDTV.setText(postsList.get(position).getUserId()+"");
        holder.titleTV.setText(postsList.get(position).getTitle());
        holder.bodyTV.setText(postsList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView userIDTV;
        TextView titleTV;
        TextView bodyTV;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            userIDTV = itemView.findViewById(R.id.userIDTV);
            titleTV = itemView.findViewById(R.id.titleTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);
        }
    }

    public void setList(ArrayList<PostModel> list){
        this.postsList = list;
    }
}
