package com.example.facebookv2.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.example.facebookv2.R;
import com.example.facebookv2.data.PostsClient;
import com.example.facebookv2.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();
        recyclerView = findViewById(R.id.RecyclerView);



        Adapter adapter = new Adapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList((ArrayList<PostModel>) postModels);
                recyclerView.setAdapter(adapter);
            }
        });


    }
}