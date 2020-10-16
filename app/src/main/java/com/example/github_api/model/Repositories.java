package com.example.github_api.model;


import com.example.github_api.model.repo.Repo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Repositories {
    @SerializedName("items")
    @Expose
    private ArrayList<Repo> repo;

    public ArrayList<Repo> getRepo() {
        return repo;
    }

    public void setRepo(ArrayList<Repo> repo) {
        this.repo = repo;
    }

    @Override
    public String toString() {
        return "Repositories{" +
                "repo=" + repo +
                '}';
    }
}
