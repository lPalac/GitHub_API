package com.example.github_api;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.github_api.model.Repositories;
import com.example.github_api.model.repo.ExampleAdapter;
import com.example.github_api.model.repo.Repo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView textViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResults = findViewById(R.id.header);//textThingy je bilo

        retrofitSetup();
    }

    void retrofitSetup() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubPlaceholderApi gitHubPlaceholderApi = retrofit.create(GitHubPlaceholderApi.class);
        Call<Repositories> call = gitHubPlaceholderApi.getRepositories();

        call.enqueue(new Callback<Repositories>() {
            @Override
            public void onResponse(Call<Repositories> call, Response<Repositories> response) {
                Log.d("Success","onResposne: " + response.toString());
                Log.d("Success","onResposne all info: " + response.body().toString());

                ArrayList<Repo> repos = response.body().getRepo();

                /*for(int i = 0; i<repos.size(); i++){
                    Log.d("Ispis",
                            "Name: " + repos.get(i).getTitle() + "\n" +
                            "Stars: " + repos.get(i).getStars() + "\n" +
                            "ImageURL: " + repos.get(i).getOwner() + "\n");
                }*/

                recyclerviewSetup(repos);

            }

            @Override
            public void onFailure(Call<Repositories> call, Throwable t) {
                Log.e("Error","onFailure: Something went wrong: " + t.getMessage());
            }
        });
    }

    void recyclerviewSetup(ArrayList<Repo> repos){
        /*
        ArrayList<Items> itemsList = new ArrayList<>();
        itemsList.add(new Items("URL.neki", "Linija jedan", "10502"));
        itemsList.add(new Items("URL.neki", "Linija dva", "10932"));
        itemsList.add(new Items("URL.neki", "Linija tri", "12504"));*/

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(repos,this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}