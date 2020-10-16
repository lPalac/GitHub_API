package com.example.github_api.api;

import com.example.github_api.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface  Service {
    @GET("/search/repositories?q=stars:>=100000&sort=stars&order=desc")
    Call<ItemResponse> getItems();
}
