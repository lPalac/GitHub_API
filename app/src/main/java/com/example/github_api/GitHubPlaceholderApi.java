package com.example.github_api;

import com.example.github_api.model.Repositories;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GitHubPlaceholderApi {

    @Headers("Content-Type: application/json")
    @GET("search/repositories?q=stars:>=100000&sort=stars&order=desc")
    Call<Repositories> getRepositories();
}
